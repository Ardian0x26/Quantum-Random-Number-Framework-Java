package quanrint64;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Generator {

    public static String line; //Temp store for read out lines
    public static String randNum; //Random number store as string, this is the output of the python script

    public Generator() {
    }

    public static String getLine() {
        return line;
    }

    public static void setLine(String line) {
        Generator.line = line;
    }

    public static String getRandNum() {
        return randNum;
    }

    public static void setRandNum(String randNum) {
        Generator.randNum = randNum;
    }

    /**
     *
     * Calls a python script which creates random integer and reads out the result
     * @param qubits Is an integer value which defines, how many qubits are used to generate this random number, you can choose between 1 and 5 whereas for example with
     *               2 qubits there are four possbile results, 00, 01 , 10, 11, so 2^2 results
     * @param token Is your IBMQ API Account Token
     * @param backend Is the backend server, you can find all here: https://quantum-computing.ibm.com/services/resources?tab=systems
     */
    public static Integer generateQRandInt(Integer qubits, String token, String backend) throws IOException, InterruptedException, URISyntaxException {
        if(qubits < 1 || qubits > 5 || qubits == null) {
            throw new IllegalArgumentException();
        } else if (token.equals("")) {
            throw new IllegalArgumentException();
        } else if (token.equals("")) {
            throw new IllegalArgumentException();
        }
        Path path = Paths.get(Generator.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        File file = new File(path.toString() + "\\qiskit\\venv\\qrand.py");

        System.out.print(path + "\n");
        System.out.print(file.getAbsolutePath() + "\n");

        String absolutePathToPy = file.getAbsolutePath();
        String[] cmd = new String[5];
        cmd[0] = "python";
        cmd[1] = absolutePathToPy;
        cmd[2] = qubits.toString();
        cmd[3] = token;
        cmd[4] = backend;
        Runtime r = Runtime.getRuntime();

        Process p = r.exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = in.readLine()) != null) {
            // System.out.print(s);
            randNum = line;
        }
        return Integer.valueOf(randNum);
    }
}
