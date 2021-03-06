package org.deeplearning4j.models.layers;

import org.deeplearning4j.datasets.fetchers.MnistDataFetcher;
import org.deeplearning4j.nn.api.LayerFactory;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.layers.ConvolutionDownSampleLayer;
import org.deeplearning4j.nn.layers.factory.LayerFactories;
import org.junit.Test;
import org.junit.Ignore;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by agibsonccc on 9/7/14.
 */
public class ConvolutionDownSampleLayerTest {


    @Test
    public void testConvolution() throws Exception {
        boolean switched = false;
        if(Nd4j.dtype == DataBuffer.FLOAT) {
            Nd4j.dtype = DataBuffer.DOUBLE;
            switched = true;
        }
        MnistDataFetcher data = new MnistDataFetcher(true);
        data.fetch(2);
        DataSet d = data.next();

        d.setFeatures(d.getFeatureMatrix().reshape(2,1,28,28));

        NeuralNetConfiguration n = new NeuralNetConfiguration.Builder()
                .filterSize(new int[]{2,2}).numFeatureMaps(2)
                .weightShape(new int[]{2, 3, 9, 9}).build();

        LayerFactory l = LayerFactories.getFactory(ConvolutionDownSampleLayer.class);
        ConvolutionDownSampleLayer c = l.create(n);

        INDArray convolved = c.activate(d.getFeatureMatrix());
        if(switched) {
            Nd4j.dtype = DataBuffer.FLOAT;
        }

    }


}
