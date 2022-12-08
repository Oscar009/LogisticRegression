package classes;

public class logisticRegression {
  // Inicialize
  // Training set
  double[] x1 = { 1, 4, 2 };
  double[] x2 = { 1, 2, 4 };

  double[] yi = { 0, 1, 1 };

  double learningRate = 0.1;
  int iterations = 100;
  // weights
  double[] wj = { 0, 0, 0 };

  // predictions
  double x1p = 4;
  double x2p = 3.5;

  public logisticRegression() {
    while (iterations > 0) {
      iterations = iterations - 1;
      double aux1 = 0, aux2 = 0, aux3 = 0;
      for (int i = 0; i < yi.length; i++) {
        aux1 = aux1 + (((1 / (1 + Math.pow(Math.E, -(wj[0] + (wj[1] * x1[i]) + (wj[2] * x2[i]))))) - yi[i]));
        aux2 = aux2 + (((1 / (1 + Math.pow(Math.E, -(wj[0] + (wj[1] * x1[i]) + (wj[2] * x2[i]))))) - yi[i]) * x1[i]);
        aux3 = aux3 + (((1 / (1 + Math.pow(Math.E, -(wj[0] + (wj[1] * x1[i]) + (wj[2] * x2[i]))))) - yi[i]) * x2[i]);
      }
      wj[0] = wj[0] - learningRate * aux1;
      wj[1] = wj[1] - learningRate * aux2;
      wj[2] = wj[2] - learningRate * aux3;
      System.out.println("Vueltas restantes: " + iterations);
      System.out.println("{" + wj[0] + ", " + wj[1] + ", " + wj[2] + "}");
    }

    prediction();
  }

  public void prediction() {
    double result = 1 / (1 + Math.pow(Math.E, -(wj[0] + (wj[1] * x1p) + (wj[2] * x2p))));
    System.out.println("Prediction {" + x1p + ", " + x2p + "} = " + result);
    System.out.println("Clasificacion: ");
    if (result > 0.5)
      System.out.println("SI");
    else
      System.out.println("NO");
  }

}
