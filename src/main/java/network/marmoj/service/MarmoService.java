package network.marmoj.service;

import network.marmoj.model.core.Intent;
import network.marmoj.model.core.SignedIntent;

import java.math.BigInteger;
import java.util.List;

public interface MarmoService {

    boolean setup(String nodeAddress, String contractAddress, String privateKey);

    Intent create(List<byte[]> dependencies, String to, String signer, BigInteger value, String data, BigInteger minGasLimit, BigInteger maxGasPrice, byte[] salt);

    SignedIntent sign(Intent intent);


}
