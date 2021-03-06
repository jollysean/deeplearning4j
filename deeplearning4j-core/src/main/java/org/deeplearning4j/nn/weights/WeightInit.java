package org.deeplearning4j.nn.weights;

/**
 * Weight initialization scheme
 * @author Adam Gibson
 */
public enum WeightInit {
    /*
        Variance normalized initialization (VI) (Glorot)
        Sparse initialization (SI) (Martens)
        Zeros: straight zeros
        Sample weights from a distribution
     */
    VI,ZERO, SIZE, DISTRIBUTION,NORMALIZED,UNIFORM

}
