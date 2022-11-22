# Quantum-Random-Number-Framework-Java
This is a framework to generate quantum numbers in java easily between 0 and 31 (till now)

The .jar you can import as library you can find under: 
Quantum-Random-Number-Framework-Java\out\artifacts\QRNF_jar

NOTE: Please keep the folder "qiskit" always in the same folder with the jar, this is necessary for QRNF.jar to work

To use the lib, import it to your project, which is IDE specific, then

in Java:

import quanrint64.Generator;

To use it call Geenrator.generateQRandInt(int qubits, String token, String backend);

qubits: you can choose a number between 1 and 5

token: is your IBMQ Account API Token

backend: Is the IBMQ quantum computer server, which you can choose here: 

https://quantum-computing.ibm.com/services/resources?tab=systems


