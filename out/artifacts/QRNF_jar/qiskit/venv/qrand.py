from qiskit import QuantumCircuit, execute, Aer, IBMQ, ClassicalRegister, QuantumRegister
import sys


def calcQRandInt(qubits,token,pBackend):
    IBMQ.save_account(token,overwrite=True)
    provider = IBMQ.load_account()
    backend = provider.get_backend(pBackend,hub=None)
    classicBits = qubits
    qc = QuantumCircuit(int(qubits), int(classicBits))
    for i in range(0, int(qubits)):
        qc.h(i)
    qc.measure(range(int(qubits)), range(int(qubits)))
    shots = 1
    job = execute(qc, backend, shots=shots, memory=True)
    result = job.result()
    memory = result.get_memory()
    print(memory[0])
    print(int(memory[0],2))


pQubits = sys.argv[1]
pToken = sys.argv[2]
pBackend = sys.argv[3]

calcQRandInt(pQubits, pToken, pBackend)









