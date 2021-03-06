package network.marmoj.builder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import network.marmoj.Intent;
import network.marmoj.exception.ValidationException;
import network.marmoj.model.Dependency;
import network.marmoj.model.IntentAction;
import network.marmoj.utils.MarmoUtils;

public final class IntentBuilder {

  public static final int SIZE_32 = 32;

  private List<Dependency> dependencies = new ArrayList<>();
  private BigInteger expiration = BigInteger.valueOf(15);
  private String salt = MarmoUtils.PREFIX;

  /* For transactions */
  private String to;
  private BigInteger value;
  private String data;
  private BigInteger maxGasLimit = BigInteger.valueOf(0);
  private BigInteger maxGasPrice = BigInteger.valueOf(9999999999L);

  private IntentBuilder() {
  }

  public static IntentBuilder anIntent() {
    IntentBuilder intentBuilder = new IntentBuilder();
    return intentBuilder;
  }

  public IntentBuilder withIntentAction(IntentAction intentAction) {
    this.to = intentAction.getTo();
    this.value = intentAction.getValue();
    this.data = intentAction.getData();
    return this;
  }

  public IntentBuilder withExpiration(BigInteger days) {
    this.expiration = days;
    return this;
  }

  public IntentBuilder withDependencies(List<Dependency> dependencies) {
    this.dependencies.addAll(dependencies);
    return this;
  }

  public IntentBuilder withMaxGasLimit(BigInteger minGasLimit) {
    this.maxGasLimit = minGasLimit;
    return this;
  }

  public IntentBuilder withMaxGasPrice(BigInteger maxGasPrice) {
    this.maxGasPrice = maxGasPrice;
    return this;
  }

  public IntentBuilder withSalt(String salt) {
    this.salt = salt;
    return this;
  }

  public Intent build() {
    if (to == null || value == null) {
      throw new ValidationException("intentAction");
    }

    return new Intent(dependencies, salt, to, expiration, value, data, maxGasLimit, maxGasPrice);
  }


}
