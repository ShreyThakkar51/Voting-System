import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException.*;

import javax.lang.model.util.ElementScanner6;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class election {
    election head;
    String name;
    String date;
    election next;

    election() {
        this.name = null;
        this.date = null;
        this.next = null;
    }

    election(String name, String date) {
        this.name = name;
        this.date = date;
        this.next = null;
    }
}

class CandCandidate {
    CandCandidate head;
    String name;
    int age;
    String Voter_id;
    String nationality;
    String Address;
    int vote;
    String parthyname;
    CandCandidate next;

    CandCandidate() {
        this.name = null;
        this.age = 0;
        this.Voter_id = null;
        this.nationality = null;
        this.Address = null;
        this.parthyname = null;
        this.vote = 0;
        this.next = null;

    }

    CandCandidate(String name, int age, String Voter_id, String nationality, String Address, String parthyname) {
        this.name = name;
        this.age = age;
        this.Voter_id = Voter_id;
        this.nationality = nationality;
        this.Address = Address;
        this.parthyname = parthyname;
        this.vote = 0;
        this.next = null;
    }
}

class CandCandidate1 {
    CandCandidate head;
    String name;
    int age;
    String Voter_id;
    String nationality;
    String Address;
    int vote;
    String parthyname;
    CandCandidate next;

    CandCandidate1() {
        this.name = null;
        this.age = 0;
        this.Voter_id = null;
        this.nationality = null;
        this.Address = null;
        this.parthyname = null;
        this.vote = 0;
        this.next = null;

    }

    CandCandidate1(String name, int age, String Voter_id, String nationality, String Address, String parthyname) {
        this.name = name;
        this.age = age;
        this.Voter_id = Voter_id;
        this.nationality = nationality;
        this.Address = Address;
        this.parthyname = parthyname;
        this.vote = 0;
        this.next = null;
    }
}

class CandCandidate2 {
    CandCandidate head;
    String name;
    int age;
    String Voter_id;
    String nationality;
    String Address;
    int vote;
    String parthyname;
    CandCandidate next;

    CandCandidate2() {
        this.name = null;
        this.age = 0;
        this.Voter_id = null;
        this.nationality = null;
        this.Address = null;
        this.parthyname = null;
        this.vote = 0;
        this.next = null;

    }

    CandCandidate2(String name, int age, String Voter_id, String nationality, String Address, String parthyname) {
        this.name = name;
        this.age = age;
        this.Voter_id = Voter_id;
        this.nationality = nationality;
        this.Address = Address;
        this.parthyname = parthyname;
        this.vote = 0;
        this.next = null;
    }
}

class voter {
    voter head;
    String vname;
    String bday;
    String vvoter_id;
    voter next;

    voter() {
        this.vname = null;
        this.bday = null;
        this.vvoter_id = null;
        this.next = null;
    }

    voter(String vname, String bday, String vvoter_id) {
        this.vname = vname;
        this.bday = bday;
        this.vvoter_id = vvoter_id;
        this.next = null;

    }
}

class ADMINISTRATOR {
    // private static final String Int_line = null;

    election Addelection(election e, election new_node) {

        if (e.head == null) {
            e.head = new_node;

        } else {
            election ptr = e.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new_node;
        }
        return e;
    }

    CandCandidate Addcandidate(CandCandidate c, CandCandidate new_node) {
        if (c.head == null) {
            c.head = new_node;
        } else {
            CandCandidate ptr = c.head;
            while (ptr.next != null) {
                ptr = ptr.next;

            }
            ptr.next = new_node;
        }
        return c;
    }

    CandCandidate Addcandidate2(CandCandidate c2, CandCandidate new_node) {
        if (c2.head == null) {
            c2.head = new_node;
        } else {
            CandCandidate ptr = c2.head;
            while (ptr.next != null) {
                ptr = ptr.next;

            }
            ptr.next = new_node;
        }
        return c2;
    }

    CandCandidate Addcandidate1(CandCandidate c1, CandCandidate new_node) {
        if (c1.head == null) {
            c1.head = new_node;
        } else {
            CandCandidate ptr = c1.head;
            while (ptr.next != null) {
                ptr = ptr.next;

            }
            ptr.next = new_node;
        }
        return c1;
    }

    voter vadd(voter v, voter new_node) {
        if (v.head == null) {
            v.head = new_node;
        } else {
            voter ptr = v.head;
            while (ptr.next != null) {
                ptr = ptr.next;

            }
            ptr.next = new_node;
        }
        return v;
    }

    void eadd(election e) {
        Scanner sc = new Scanner(System.in);
        String name;
        String date;
        System.out.println();
        System.out.print("                                              Enter Election Name : --->");
        name = sc.nextLine();
        System.out.print("                                              Enter Election Date(DD/MM/YYYY) : --->");
        date = sc.nextLine();

        election new_node = new election(name, date);
        e = Addelection(e, new_node);
        writeTofile(e, new_node);
    }

    void writeTofile(election e, election new_node) {
        File file = new File("election.csv");
        try {

            FileWriter fw = new FileWriter("election.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.printf("%s,%s\n", new_node.name, new_node.date);

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException f) {

            f.printStackTrace();
        } finally {
        }
    }

    void Addcandi(CandCandidate c) {
        Scanner sc = new Scanner(System.in);
        String cname;
        String cvoterid;
        int cage;
        String cnationality;
        String cparthy;
        String caddress;
        String nation = "india";
        System.out.println();
        System.out.print("                                              Enter Candidate Name : --->");
        cname = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Age : --->");
        cage = sc.nextInt();
        if (cage < 18) {
            System.out.println("                                              Candidate did not elegible for election");
            return;
        }
        System.out.println();
        System.out.print("                                              Enter Candidate Voter-Id : --->");
        cvoterid = sc.next();
        System.out.println();
        while (cvoterid.length() != 12) {
            System.out.println("                                              Invalid Id !! please Enter Again ");
            System.out.println();
            System.out.print("                                              Enter Candidate Voter-Id : --->");
            cvoterid = sc.next();
        }
        System.out.print("                                              Enter Candidate nationality : --->");
        cnationality = sc.next();
        System.out.println();
        if (nation.compareTo(cnationality) != 0) {
            System.out.println("                                              You are not Inhabitant of india");
            System.out.println("                                              You can't parcipate in election");
            return;
        }
        System.out.print("                                              Enter Candidate Address : --->");
        caddress = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Party-name : --->");
        cparthy = sc.next();
        System.out.println();
        CandCandidate new_node = new CandCandidate(cname, cage, cvoterid, cnationality, caddress, cparthy);
        c = Addcandidate(c, new_node);
        writecantofile(c, new_node);

    }

    void Addcandi1(CandCandidate c1) {
        Scanner sc = new Scanner(System.in);
        String cname;
        String cvoterid;
        int cage;
        String cnationality;
        String cparthy;
        String caddress;
        String nation = "india";
        System.out.println();
        System.out.print("                                              Enter Candidate Name : --->");
        cname = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Age : --->");
        cage = sc.nextInt();
        if (cage < 18) {
            System.out.println("                                              Candidate did not elegible for election");
            return;
        }
        System.out.println();
        System.out.print("                                              Enter Candidate Voter-Id : --->");
        cvoterid = sc.next();
        System.out.println();
        while (cvoterid.length() != 12) {
            System.out.println("                                              Invalid Id !! please Enter Again ");
            System.out.println("                                              Enter Candidate Voter-Id : --->");
            cvoterid = sc.next();
        }
        System.out.print("                                              Enter Candidate nationality : --->");
        cnationality = sc.next();
        System.out.println();
        if (nation.compareTo(cnationality) != 0) {
            System.out.println("                                              You are not Inhabitant of india");
            System.out.println("                                              You can't parcipate in election");
            return;
        }
        System.out.print("                                              Enter Candidate Address : --->");
        caddress = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Party-name : --->");
        cparthy = sc.next();
        System.out.println();
        CandCandidate new_node = new CandCandidate(cname, cage, cvoterid, cnationality, caddress, cparthy);
        c1 = Addcandidate1(c1, new_node);
        writecantofile1(c1, new_node);

    }

    void Addcandi2(CandCandidate c2) {
        Scanner sc = new Scanner(System.in);
        String cname;
        String cvoterid;
        int cage;
        String cnationality;
        String cparthy;
        String caddress;
        String nation = "india";
        System.out.println();
        System.out.print("                                              Enter Candidate Name : --->");
        cname = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Age : --->");
        cage = sc.nextInt();
        if (cage < 18) {
            System.out.println("                                              Candidate did not elegible for election");
            return;
        }
        System.out.println();
        System.out.print("                                              Enter Candidate Voter-Id : --->");
        cvoterid = sc.next();
        System.out.println();
        while (cvoterid.length() != 12) {
            System.out.println("                                              Invalid Id !! please Enter Again ");
            System.out.println("                                              Enter Candidate Voter-Id : --->");
            cvoterid = sc.next();
        }
        System.out.print("                                              Enter Candidate nationality : --->");
        cnationality = sc.next();
        System.out.println();
        if (nation.compareTo(cnationality) != 0) {
            System.out.println("                                              You are not Inhabitant of india");
            System.out.println("                                              You can't parcipate in election");
            return;
        }
        System.out.print("                                              Enter Candidate Address : --->");
        caddress = sc.next();
        System.out.println();
        System.out.print("                                              Enter Candidate Party-name : --->");
        cparthy = sc.next();
        System.out.println();
        CandCandidate new_node = new CandCandidate(cname, cage, cvoterid, cnationality, caddress, cparthy);
        c2 = Addcandidate2(c2, new_node);
        writecantofile2(c2, new_node);

    }

    void writecantofile(CandCandidate c, CandCandidate new_node) {
        File file = new File("candidet.csv");

        try {
            FileWriter fw = new FileWriter("candidet.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.printf("%s,%d,%s,%s,%s,%s\n", new_node.name, new_node.age, new_node.Voter_id, new_node.nationality,
                    new_node.Address, new_node.parthyname);

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException f) {

            f.printStackTrace();
        } finally {
        }
    }

    void writecantofile1(CandCandidate c1, CandCandidate new_node) {
        File file = new File("candidet1.csv");

        try {
            FileWriter fw = new FileWriter("candidet1.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.printf("%s,%d,%s,%s,%s,%s\n", new_node.name, new_node.age, new_node.Voter_id, new_node.nationality,
                    new_node.Address, new_node.parthyname);

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException f) {

            f.printStackTrace();
        } finally {
        }
    }

    void writecantofile2(CandCandidate c2, CandCandidate new_node) {
        File file = new File("candidet2.csv");

        try {
            FileWriter fw = new FileWriter("candidet2.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.printf("%s,%d,%s,%s,%s,%s\n", new_node.name, new_node.age, new_node.Voter_id, new_node.nationality,
                    new_node.Address, new_node.parthyname);

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException f) {

            f.printStackTrace();
        } finally {
        }
    }

    void writevottofile(voter v, voter new_node) {
        File file = new File("voter.csv");

        try {
            FileWriter fw = new FileWriter("voter.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.printf("%s,%s,%s\n", new_node.vname, new_node.bday, new_node.vvoter_id);

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException f) {

            f.printStackTrace();
        } finally {
        }
    }

    void addvoter(voter v) {
        Scanner sc = new Scanner(System.in);
        String name;
        String bday;
        String voterid;

        System.out.print("                                              Enter Voter Name : --->");
        name = sc.next();
        System.out.print("                                              Enter Voter Birth-Date : --->");
        bday = sc.next();
        System.out.print("                                              Enter Candidate Voter-Id : --->");
        voterid = sc.next();
        System.out.println();
        while (voterid.length() != 12) {
            System.out.println("                                              Invalid Id !! please Enter Again ");
            System.out.println("                                              Enter Voter's Voter-Id : --->");
            voterid = sc.next();
        }

        voter new_node = new voter(name, bday, voterid);
        writevottofile(v, new_node);

    }

    void votdisplay(voter v) {
        Path pathToFile = Paths.get("voter.csv");

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII);
            String line = br.readLine();
            // line = br.readLine();

            while (line != null) {

                String[] voters = line.split(",");
                String name = voters[0];
                String bday = voters[1];
                String voter_id = voters[2];
                System.out.println();
                System.out.println("                                              #################################");
                System.out.println("                                              Voter's Name      ---> " + name);
                System.out.println("                                              Voter's birth-date ---> " + bday);
                System.out.println("                                              Voter's Voter-id  ---> " + voter_id);
                // System.out.println();

                line = br.readLine();
            }

        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("                                              #################################");
        System.out.println();

        // return v;
    }

    void candisplay(CandCandidate c) {
        Path pathToFile = Paths.get("candidet.csv");

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII);
            String line = br.readLine();
            // line = br.readLine();

            while (line != null) {

                String[] can = line.split(",");
                String name = can[0];
                String age = can[1];
                String voter_id = can[2];
                String nationality = can[3];
                String Address = can[4];
                String partyname = can[5];
                System.out.println();
                System.out.println("                                              #################################");
                System.out
                        .println("                                              candidate's Name        ---> " + name);
                System.out.println("                                              candidate's birth-day   ---> " + age);
                System.out.println(
                        "                                              candidate's Voter-id    ---> " + voter_id);
                System.out.println(
                        "                                              candidate's Nationality ---> " + nationality);
                System.out.println(
                        "                                              candidate's Address     ---> " + Address);
                System.out.println(
                        "                                              candidate's Party-name  ---> " + partyname);
                // System.out.println();

                line = br.readLine();
            }

        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("                                              #################################");
        System.out.println();

        // return v;
    }

    void candisplay1(CandCandidate c1) {
        Path pathToFile = Paths.get("candidet1.csv");

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII);
            String line = br.readLine();
            // line = br.readLine();

            while (line != null) {

                String[] can = line.split(",");
                String name = can[0];
                String age = can[1];
                String voter_id = can[2];
                String nationality = can[3];
                String Address = can[4];
                String partyname = can[5];
                System.out.println();
                System.out.println("                                              #################################");
                System.out
                        .println("                                              candidate's Name        ---> " + name);
                System.out.println("                                              candidate's birth-day   ---> " + age);
                System.out.println(
                        "                                              candidate's Voter-id    ---> " + voter_id);
                System.out.println(
                        "                                              candidate's Nationality ---> " + nationality);
                System.out.println(
                        "                                              candidate's Address     ---> " + Address);
                System.out.println(
                        "                                              candidate's Party-name  ---> " + partyname);
                // System.out.println();

                line = br.readLine();
            }

        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("                                              #################################");
        System.out.println();

        // return v;
    }

    void candisplay2(CandCandidate c2) {
        Path pathToFile = Paths.get("candidet2.csv");

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII);
            String line = br.readLine();
            // line = br.readLine();

            while (line != null) {

                String[] can = line.split(",");
                String name = can[0];
                String age = can[1];
                String voter_id = can[2];
                String nationality = can[3];
                String Address = can[4];
                String partyname = can[5];
                System.out.println();
                System.out.println("                                              #################################");
                System.out
                        .println("                                              candidate's Name        ---> " + name);
                System.out.println("                                              candidate's birth-day   ---> " + age);
                System.out.println(
                        "                                              candidate's Voter-id    ---> " + voter_id);
                System.out.println(
                        "                                              candidate's Nationality ---> " + nationality);
                System.out.println(
                        "                                              candidate's Address     ---> " + Address);
                System.out.println(
                        "                                              candidate's Party-name  ---> " + partyname);
                // System.out.println();

                line = br.readLine();
            }

        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("                                              #################################");
        System.out.println();

        // return v;
    }

    void startele(election e, CandCandidate c, CandCandidate c1, CandCandidate c2, voter v, ADMINISTRATOR A) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.print("                                              Entre Today's Date(dd/mm/yyyy) ---> ");
        s = sc.nextLine();
        int i = 0;
        int vx = 0;
        try {
            Path pathToFilex = Paths.get("voter.csv");
            BufferedReader brx = Files.newBufferedReader(pathToFilex,
                    StandardCharsets.US_ASCII);
            String linex = brx.readLine();

            while (linex != null) {
                vx++;
                linex = brx.readLine();

            }
        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        }
        Path pathToFile = Paths.get("election.csv");

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII);
            String line = br.readLine();
            // line = br.readLine();
            String[] ptr = line.split(",");
            while (line != null) {
                ptr = line.split(",");
                i++;
                if (s.compareTo(ptr[1]) == 0) {
                    break;
                }
                line = br.readLine();

            }

            int tc = 0;
            Path pathToFiletc = Paths.get("candidet.csv");
            try {
                BufferedReader brtc = Files.newBufferedReader(pathToFiletc,
                        StandardCharsets.US_ASCII);
                String linetc = brtc.readLine();
                // line = br.readLine();
                String[] ptrtc = linetc.split(",");
                while (linetc != null) {
                    tc++;
                    linetc = brtc.readLine();

                }
                int[] voting = new int[tc];
                if (i == 1) {
                    int ele = 1;
                    System.out.print("                                              Election Name  --->  " + ptr[0]);
                    System.out.println();
                    while (ele != 0) {
                        String x;
                        System.out.println();
                        ;
                        System.out.print("                                              Entre Voter-Id ---> ");
                        x = sc.next();
                        try {
                            Path pathToFile1 = Paths.get("voter.csv");
                            BufferedReader br1 = Files.newBufferedReader(pathToFile1,
                                    StandardCharsets.US_ASCII);
                            String line1 = br1.readLine();
                            // line = br.readLine();
                            // String[] ptr1 = line1.split(",");
                            int j = 0;
                            while (line1 != null) {
                                String[] ptr1 = line1.split(",");
                                if (x.compareTo(ptr1[2]) == 0) {
                                    break;
                                }
                                j++;
                                line1 = br1.readLine();
                            }

                            if (j == vx) {
                                System.out.print("                                              Not Found !!");
                            } else {
                                try {
                                    Path pathToFilec = Paths.get("candidet.csv");
                                    BufferedReader brc = Files.newBufferedReader(pathToFilec,
                                            StandardCharsets.US_ASCII);
                                    String linec = brc.readLine();
                                    int totalc = 0;
                                    while (linec != null) {

                                        String[] can = linec.split(",");
                                        String name = can[0];
                                        String partyname = can[5];
                                        System.out.println();
                                        System.out.println(
                                                "                                              ####################################");
                                        System.out.println(
                                                "                                              candidate's Name        ---> "
                                                        + name);
                                        System.out.println(
                                                "                                              candidate's Party-name  ---> "
                                                        + partyname);
                                        System.out.println(
                                                "                                              ####################################");
                                        // System.out.println();

                                        linec = brc.readLine();
                                        totalc++;
                                    }

                                    String choise;
                                    System.out.print(
                                            "                                              Enter your chosen Candidate Name : ");
                                    choise = sc.next();
                                    try {

                                        Path pathToFilecc = Paths.get("candidet.csv");
                                        BufferedReader brcc = Files.newBufferedReader(pathToFilecc,
                                                StandardCharsets.US_ASCII);
                                        String linecc = brcc.readLine();
                                        // line = br.readLine();
                                        String[] ptrcc = linecc.split(",");
                                        int jj = 0;
                                        while (linecc != null) {
                                            ptrcc = linecc.split(",");
                                            if (choise.compareTo(ptrcc[0]) == 0) {
                                                break;
                                            }
                                            jj++;
                                            linecc = brcc.readLine();
                                        }
                                        if (jj == tc) {
                                            System.out
                                                    .print("                                              Not found !");
                                            break;
                                        } else {
                                            voting[jj] += 1;
                                        }

                                    } catch (

                                    IOException ioe) {
                                        ioe.printStackTrace();
                                    } finally {

                                    }

                                } finally {

                                }
                                System.out.println();
                                System.out.print(
                                        "                                              Enter 0 for exit 1 forcontinue ");
                                ele = sc.nextInt();
                                if (ele == 0) {
                                    break;
                                }
                            }
                        }
                        // }
                        catch (

                        IOException ioe) {
                            ioe.printStackTrace();
                        } finally {

                        }

                    }
                    if (ele == 0) {
                        File file = new File("vote1.csv");
                        try {
                            FileWriter fw = new FileWriter("vote1.csv", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            for (int mn = 0; mn < tc; mn++) {

                                pw.printf("%d\n", voting[mn]);
                            }
                            pw.close();
                            bw.close();
                            fw.close();
                        } catch (IOException f) {
                            f.printStackTrace();
                        } finally {

                        }
                        System.out.println("                                              Finished.");
                    }
                }

            } catch (

            IOException ioe) {
                ioe.printStackTrace();
            } finally {

            }
        } catch (

        IOException ioe) {
            ioe.printStackTrace();
        } finally {

        }

    }
    

    void Result(election e, CandCandidate c, CandCandidate c1, CandCandidate c2, voter v, ADMINISTRATOR A) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.print("                                              Entre Election Name ---->  ");
        s = sc.nextLine();

        int i = 1;

        if (i == 1) {
            int tc = 0;
            Path pathToFiletc = Paths.get("candidet.csv");
            try {
                BufferedReader brtc = Files.newBufferedReader(pathToFiletc,
                        StandardCharsets.US_ASCII);
                String linetc = brtc.readLine();
                // line = br.readLine();;
                while (linetc != null) {
                    tc++;
                    linetc = brtc.readLine();

                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            int[] tempresult = new int[tc];
            int k = 0;
            Path pathToFiletr = Paths.get("vote1.csv");
            try {
                BufferedReader brr = Files.newBufferedReader(pathToFiletr,
                        StandardCharsets.US_ASCII);
                String linee = brr.readLine();
                while (linee != null) {
                    String ss = linee;
                    tempresult[k] = Integer.parseInt(ss);
                    linee = brr.readLine();
                    k++;

                }
            } catch (

            IOException ioe) {
                ioe.printStackTrace();
            } finally {
            }
            int[] tempr = new int[tc];
            for (int jk = 0; jk < tc; jk++) {
                tempr[jk] = tempresult[jk];
            }
            for (int j = 0; j < tc; j++) {
                for (int kk = j; kk < tc; kk++) {

                    if (tempr[kk] < tempr[j]) {
                        int temp = tempr[kk];
                        tempr[kk] = tempr[j];
                        tempr[j] = temp;

                    }
                }

            }
            int j;
            for (j = 0; j < tc; j++) {
                if (tempresult[j] == tempr[tc - 1]) {
                    break;
                }
            }
            try {
                Path pathToFilec = Paths.get("candidet.csv");
                BufferedReader brc = Files.newBufferedReader(pathToFilec,
                        StandardCharsets.US_ASCII);
                String linec = brc.readLine();
                int totalc = 0;
                while (linec != null) {

                    String[] can = linec.split(",");
                    String name = can[0];

                    linec = brc.readLine();
                  if(true){
                            System.out.println(
                                    "                                              ********************Election-winner************* ");
                            System.out.println(
                                    "                                              Winner  Name        ---->  " + name);
                            System.out
                                    .println("                                              Winner's Total vote ---->  "
                                            + tempr[tc - 1]);
                            break;
                        }
                    }
                    totalc++;

                }
            catch (
                
            IOException ioe) {
                ioe.printStackTrace();
            } finally {
            }

            try {
                Files.deleteIfExists(
                        Paths.get("candidet.csv"));
            } catch (IOException f) {
                System.out.println("Invalid permissions.");
            }

            try {
                Files.deleteIfExists(
                        Paths.get("election.csv"));
            } catch (IOException f) {
                System.out.println("Invalid permissions.");
            }

            try {
                Files.deleteIfExists(
                        Paths.get("vote1.csv"));
            } catch (IOException f) {
                System.out.println("Invalid permissions.");
            }

        }
    }
}

public class Voting {

    static void Admin(election e, CandCandidate c, CandCandidate c1, CandCandidate c2, voter v, ADMINISTRATOR A) {
        Scanner sc = new Scanner(System.in);
        int j = 1;
        while (j != 0) {

            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              *************      ADMINISTRATOR      *********** ");
            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              * Press----> 1 To Add Election                  *");
            System.out.println(
                    "                                              * Press----> 2 To Add Candidate                 *");
            System.out.println(
                    "                                              * Press----> 3 To Add voter                     *");
            System.out.println(
                    "                                              * Press----> 4 To View Candidate list           *");
            System.out.println(
                    "                                              * Press----> 5 To View voter list               *");
            System.out.println(
                    "                                              * Press----> 6 To start election                *");
            System.out.println(
                    "                                              * Press----> 7 To View Result of election       *");
            System.out.println(
                    "                                              * Press----> 0 TO EXIT                          *");
            System.out.println(
                    "                                              *************************************************");
            System.out.print("                                              Enter Your Choice --->");
            j = sc.nextInt();
            if (j == 1) {
                A.eadd(e);
            } else if (j == 2) {
                A.Addcandi(c);
            }
            // else if (j == 3) {
            // A.Addcandi1(c1);
            // } else if (j == 4) {
            // A.Addcandi2(c2);
            // }
            else if (j == 3) {
                A.addvoter(v);

            } else if (j == 4) {

                A.candisplay(c);
            } else if (j == 5) {
                A.votdisplay(v);
            } else if (j == 6) {
                A.startele(e, c, c1, c2, v, A);
            } else if (j == 7) {
                A.Result(e, c, c1, c2, v, A);
            }
        }
    }

    static void voting(election e, CandCandidate c, CandCandidate c1, CandCandidate c2, voter v, ADMINISTRATOR A) {
        Scanner sc = new Scanner(System.in);
        int x = 1;

        while (x != 0) {

            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              *************           Voter         *********** ");
            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              * Press----> 1 To Resister                      *");
            System.out.println(
                    "                                              * Press----> 0 TO EXIT                          *");
            System.out.println(
                    "                                              *************************************************");
            System.out.print("                                              Enter Your Choice --->");
            x = sc.nextInt();
            if (x == 1) {
                A.addvoter(v);
            }

        }

    }

    public static void main(String[] args) {
        int i = 1;
        Scanner sc = new Scanner(System.in);
        String Login_id = new String();
        String temp = new String();
        String pass = new String();
        String temp1 = new String();
        int m = 1, n = 1;
        pass = "admin@123";
        Login_id = "admin@123";
        CandCandidate c = new CandCandidate();
        CandCandidate c1 = new CandCandidate();
        CandCandidate c2 = new CandCandidate();
        voter v = new voter();
        election e = new election();
        ADMINISTRATOR A = new ADMINISTRATOR();
        while (i != 0) {

            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              ************* Welcom in Online voting *********** ");
            System.out.println(
                    "                                              ************************************************* ");
            System.out.println(
                    "                                              * Press----> 1 ADMINISTRATOR                    *");
            System.out.println(
                    "                                              * Press----> 2 VOTER                            *");
            System.out.println(
                    "                                              * Press----> 0 EXIT                             *");
            System.out.println(
                    "                                              *************************************************");
            System.out.println();
            System.out.print("                                              Enter Your Choice --->");
            i = sc.nextInt();
            System.out.println();
            System.out.println();
            if (i == 1) {
                System.out.println();
                Admin(e, c, c1, c2, v, A);
            } else if (i == 2) {
                System.out.println();
                voting(e, c, c1, c2, v, A);
            }

        }

    }

}
