package network.marmoj.client.request;

import java.math.BigInteger;
import network.marmoj.Intent;
import org.web3j.utils.Numeric;

public class IntentTxRequest {

  private String to;
  private BigInteger value;
  private String data;
  private BigInteger minGasLimit;
  private BigInteger maxGasPrice;

  public IntentTxRequest(Intent intentTx) {
    this.data = intentTx.getData();
    this.minGasLimit = intentTx.getMaxGasLimit();
    this.maxGasPrice = intentTx.getMaxGasPrice();
    this.to = intentTx.getTo();
    this.value = intentTx.getValue();
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigInteger getValue() {
    return value;
  }

  public void setValue(BigInteger value) {
    this.value = value;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public BigInteger getMinGasLimit() {
    return minGasLimit;
  }

  public void setMinGasLimit(BigInteger minGasLimit) {
    this.minGasLimit = minGasLimit;
  }

  public BigInteger getMaxGasPrice() {
    return maxGasPrice;
  }

  public void setMaxGasPrice(BigInteger maxGasPrice) {
    this.maxGasPrice = maxGasPrice;
  }
}
