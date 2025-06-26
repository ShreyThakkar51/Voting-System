import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Election class
class Election {
    private String name;
    private LocalDate date;
    
    public Election(String name, String dateStr) {
        this.name = name;
        this.date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    // Getters
    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public String getDateString() { return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
    
    @Override
    public String toString() {
        return String.format("%s,%s", name, getDateString());
    }
}

// Candidate class
class Candidate {
    private String name;
    private int age;
    private String voterId;
    private String nationality;
    private String address;
    private String partyName;
    private int votes;
    
    public Candidate(String name, int age, String voterId, String nationality, 
                    String address, String partyName) {
        this.name = name;
        this.age = age;
        this.voterId = voterId;
        this.nationality = nationality;
        this.address = address;
        this.partyName = partyName;
        this.votes = 0;
    }
    
    // Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getVoterId() { return voterId; }
    public String getNationality() { return nationality; }
    public String getAddress() { return address; }
    public String getPartyName() { return partyName; }
    public int getVotes() { return votes; }
    public void addVote() { this.votes++; }
    
    @Override
    public String toString() {
        return String.format("%s,%d,%s,%s,%s,%s", name, age, voterId, nationality, address, partyName);
    }
}

// Voter class
class Voter {
    private String name;
    private String birthDate;
    private String voterId;
    
    public Voter(String name, String birthDate, String voterId) {
        this.name = name;
        this.birthDate = birthDate;
        this.voterId = voterId;
    }
    
    // Getters
    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getVoterId() { return voterId; }
    
    @Override
    public String toString() {
        return String.format("%s,%s,%s", name, birthDate, voterId);
    }
}

// File utility class
class FileUtils {
    public static void writeToFile(String filename, String data) throws IOException {
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(data);
        }
    }
    
    public static List<String> readFromFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filename);
        
        if (Files.exists(path)) {
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }
    
    public static void deleteFile(String filename) {
        try {
            Files.deleteIfExists(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error deleting file: " + filename);
        }
    }
}

// Input validation utility
class InputValidator {
    private static final String VALID_NATIONALITY = "india";
    private static final int MIN_AGE = 18;
    private static final int VOTER_ID_LENGTH = 12;
    
    public static boolean isValidAge(int age) {
        return age >= MIN_AGE;
    }
    
    public static boolean isValidVoterId(String voterId) {
        return voterId != null && voterId.length() == VOTER_ID_LENGTH;
    }
    
    public static boolean isValidNationality(String nationality) {
        return VALID_NATIONALITY.equalsIgnoreCase(nationality);
    }
}

// Main voting system class
class VotingSystem {
    private static final String ELECTION_FILE = "elections.csv";
    private static final String CANDIDATE_FILE = "candidates.csv";
    private static final String VOTER_FILE = "voters.csv";
    private static final String VOTES_FILE = "votes.csv";
    
    private List<Election> elections;
    private List<Candidate> candidates;
    private List<Voter> voters;
    private Scanner scanner;
    
    public VotingSystem() {
        this.elections = new ArrayList<>();
        this.candidates = new ArrayList<>();
        this.voters = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        loadData();
    }
    
    private void loadData() {
        try {
            // Load elections
            List<String> electionLines = FileUtils.readFromFile(ELECTION_FILE);
            for (String line : electionLines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    elections.add(new Election(parts[0], parts[1]));
                }
            }
            
            // Load candidates
            List<String> candidateLines = FileUtils.readFromFile(CANDIDATE_FILE);
            for (String line : candidateLines) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    candidates.add(new Candidate(parts[0], Integer.parseInt(parts[1]), 
                                               parts[2], parts[3], parts[4], parts[5]));
                }
            }
            
            // Load voters
            List<String> voterLines = FileUtils.readFromFile(VOTER_FILE);
            for (String line : voterLines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    voters.add(new Voter(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
    
    public void addElection() {
        try {
            System.out.print("Enter Election Name: ");
            String name = scanner.nextLine().trim();
            
            System.out.print("Enter Election Date (DD/MM/YYYY): ");
            String date = scanner.nextLine().trim();
            
            Election election = new Election(name, date);
            elections.add(election);
            
            FileUtils.writeToFile(ELECTION_FILE, election.toString());
            System.out.println("Election added successfully!");
            
        } catch (Exception e) {
            System.err.println("Error adding election: " + e.getMessage());
        }
    }
    
    public void addCandidate() {
        try {
            System.out.print("Enter Candidate Name: ");
            String name = scanner.next().trim();
            
            System.out.print("Enter Candidate Age: ");
            int age = scanner.nextInt();
            
            if (!InputValidator.isValidAge(age)) {
                System.out.println("Candidate is not eligible (minimum age: 18)");
                return;
            }
            
            System.out.print("Enter Candidate Voter ID: ");
            String voterId = scanner.next().trim();
            
            if (!InputValidator.isValidVoterId(voterId)) {
                System.out.println("Invalid Voter ID (must be 12 characters)");
                return;
            }
            
            System.out.print("Enter Candidate Nationality: ");
            String nationality = scanner.next().trim();
            
            if (!InputValidator.isValidNationality(nationality)) {
                System.out.println("Only Indian nationals can participate");
                return;
            }
            
            System.out.print("Enter Candidate Address: ");
            String address = scanner.next().trim();
            
            System.out.print("Enter Candidate Party Name: ");
            String partyName = scanner.next().trim();
            
            Candidate candidate = new Candidate(name, age, voterId, nationality, address, partyName);
            candidates.add(candidate);
            
            FileUtils.writeToFile(CANDIDATE_FILE, candidate.toString());
            System.out.println("Candidate added successfully!");
            
        } catch (Exception e) {
            System.err.println("Error adding candidate: " + e.getMessage());
        }
    }
    
    public void addVoter() {
        try {
            System.out.print("Enter Voter Name: ");
            String name = scanner.next().trim();
            
            System.out.print("Enter Voter Birth Date: ");
            String birthDate = scanner.next().trim();
            
            System.out.print("Enter Voter ID: ");
            String voterId = scanner.next().trim();
            
            if (!InputValidator.isValidVoterId(voterId)) {
                System.out.println("Invalid Voter ID (must be 12 characters)");
                return;
            }
            
            Voter voter = new Voter(name, birthDate, voterId);
            voters.add(voter);
            
            FileUtils.writeToFile(VOTER_FILE, voter.toString());
            System.out.println("Voter registered successfully!");
            
        } catch (Exception e) {
            System.err.println("Error adding voter: " + e.getMessage());
        }
    }
    
    public void displayCandidates() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }
        
        System.out.println("\n=== CANDIDATE LIST ===");
        for (Candidate candidate : candidates) {
            System.out.println("--------------------------------");
            System.out.println("Name: " + candidate.getName());
            System.out.println("Age: " + candidate.getAge());
            System.out.println("Voter ID: " + candidate.getVoterId());
            System.out.println("Nationality: " + candidate.getNationality());
            System.out.println("Address: " + candidate.getAddress());
            System.out.println("Party: " + candidate.getPartyName());
        }
        System.out.println("--------------------------------\n");
    }
    
    public void displayVoters() {
        if (voters.isEmpty()) {
            System.out.println("No voters registered.");
            return;
        }
        
        System.out.println("\n=== VOTER LIST ===");
        for (Voter voter : voters) {
            System.out.println("--------------------------------");
            System.out.println("Name: " + voter.getName());
            System.out.println("Birth Date: " + voter.getBirthDate());
            System.out.println("Voter ID: " + voter.getVoterId());
        }
        System.out.println("--------------------------------\n");
    }
    
    public void startElection() {
        if (elections.isEmpty()) {
            System.out.println("No elections scheduled.");
            return;
        }
        
        if (candidates.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }
        
        System.out.print("Enter today's date (DD/MM/YYYY): ");
        String todayStr = scanner.nextLine().trim();
        
        Election todayElection = null;
        for (Election election : elections) {
            if (election.getDateString().equals(todayStr)) {
                todayElection = election;
                break;
            }
        }
        
        if (todayElection == null) {
            System.out.println("No election scheduled for today.");
            return;
        }
        
        System.out.println("Election: " + todayElection.getName());
        
        Set<String> votedIds = new HashSet<>();
        
        while (true) {
            System.out.print("Enter Voter ID (or 'exit' to finish): ");
            String voterId = scanner.next().trim();
            
            if ("exit".equalsIgnoreCase(voterId)) {
                break;
            }
            
            if (votedIds.contains(voterId)) {
                System.out.println("This voter has already voted!");
                continue;
            }
            
            Voter voter = findVoterById(voterId);
            if (voter == null) {
                System.out.println("Voter not found!");
                continue;
            }
            
            displayCandidates();
            System.out.print("Enter candidate name to vote for: ");
            String candidateName = scanner.next().trim();
            
            Candidate candidate = findCandidateByName(candidateName);
            if (candidate == null) {
                System.out.println("Candidate not found!");
                continue;
            }
            
            candidate.addVote();
            votedIds.add(voterId);
            System.out.println("Vote recorded successfully!");
        }
        
        saveVotes();
        System.out.println("Election completed!");
    }
    
    public void showResults() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates to show results for.");
            return;
        }
        
        // Sort candidates by votes in descending order
        List<Candidate> sortedCandidates = new ArrayList<>(candidates);
        sortedCandidates.sort((c1, c2) -> Integer.compare(c2.getVotes(), c1.getVotes()));
        
        System.out.println("\n=== ELECTION RESULTS ===");
        for (int i = 0; i < sortedCandidates.size(); i++) {
            Candidate candidate = sortedCandidates.get(i);
            System.out.printf("%d. %s (%s) - %d votes%n", 
                            i + 1, candidate.getName(), candidate.getPartyName(), candidate.getVotes());
        }
        
        if (!sortedCandidates.isEmpty()) {
            Candidate winner = sortedCandidates.get(0);
            System.out.println("\n*** WINNER: " + winner.getName() + " (" + winner.getPartyName() + ") ***");
        }
        
        // Clean up files after showing results
        FileUtils.deleteFile(ELECTION_FILE);
        FileUtils.deleteFile(CANDIDATE_FILE);
        FileUtils.deleteFile(VOTES_FILE);
    }
    
    private Voter findVoterById(String voterId) {
        return voters.stream()
                    .filter(v -> v.getVoterId().equals(voterId))
                    .findFirst()
                    .orElse(null);
    }
    
    private Candidate findCandidateByName(String name) {
        return candidates.stream()
                        .filter(c -> c.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .orElse(null);
    }
    
    private void saveVotes() {
        try {
            for (Candidate candidate : candidates) {
                FileUtils.writeToFile(VOTES_FILE, String.valueOf(candidate.getVotes()));
            }
        } catch (IOException e) {
            System.err.println("Error saving votes: " + e.getMessage());
        }
    }
    
    public void runAdminMenu() {
        int choice;
        do {
            System.out.println("\n=== ADMINISTRATOR MENU ===");
            System.out.println("1. Add Election");
            System.out.println("2. Add Candidate");
            System.out.println("3. Add Voter");
            System.out.println("4. View Candidates");
            System.out.println("5. View Voters");
            System.out.println("6. Start Election");
            System.out.println("7. View Results");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: addElection(); break;
                case 2: addCandidate(); break;
                case 3: addVoter(); break;
                case 4: displayCandidates(); break;
                case 5: displayVoters(); break;
                case 6: startElection(); break;
                case 7: showResults(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
    
    public void runVoterMenu() {
        int choice;
        do {
            System.out.println("\n=== VOTER MENU ===");
            System.out.println("1. Register as Voter");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: addVoter(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}

// Main class
public class OptimizedVotingSystem {
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        do {
            System.out.println("\n=== ONLINE VOTING SYSTEM ===");
            System.out.println("1. Administrator");
            System.out.println("2. Voter");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    system.runAdminMenu();
                    break;
                case 2:
                    system.runVoterMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using the Online Voting System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
