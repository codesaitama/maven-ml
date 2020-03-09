package com.codesaitma.maventest.trainer;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

public class Machine {

    public void callTensor() throws Exception{
        try(Graph g = new Graph()){
            final String value = "Hello from " + TensorFlow.version();

            try(Tensor t = Tensor.create(value.getBytes("UTF-8"))){
                g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();
            }

            try(Session s = new Session(g);
                Tensor output = s.runner().fetch("MyConst").run().get(0)){
                System.out.println(new String(output.bytesValue(), "UTF-8"));
            }

        }
    }
}
