/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;

/**
 *
 * @author Jesus
 */
@Named(value = "beanReportes")
@RequestScoped
public class beanReportes {
 private PieChartModel model,model1;
 

  @PostConstruct
  public void init() {
      model = new PieChartModel();
      model.set("Pedidos Pendientes", 62);//jobs in thousands
      model.set("Pedidos en proceso", 46);
      model.set("Pedidos Finalizados", 38);
    

      //followings are some optional customizations:
      //set title
     
      //set legend position to 'e' (east), other values are 'w', 's' and 'n'
      model.setLegendPosition("e");
      //enable tooltips
      model.setShowDatatip(true);
      //show labels inside pie chart
      model.setShowDataLabels(true);
      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
      model.setDataFormat("value");
      //format: %d for 'value', %s for 'label', %d%% for 'percent'
      model.setDataLabelFormatString("%d");
      //pie sector colors
      model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
      
      
       model1 = new PieChartModel();
      model1.set(" Ventas al Contado", 62000);//jobs in thousands
      model1.set("Ventas a Credito", 46000);
      
    

      //followings are some optional customizations:
      //set title
     
      //set legend position to 'e' (east), other values are 'w', 's' and 'n'
      model1.setLegendPosition("e");
      //enable tooltips
      model1.setShowDatatip(true);
      //show labels inside pie chart
      model1.setShowDataLabels(true);
      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
      model1.setDataFormat("value");
      //format: %d for 'value', %s for 'label', %d%% for 'percent'
      model1.setDataLabelFormatString("%d");
      //pie sector colors
      model1.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
  }

  public PieChartModel getModel() {
      return model;
  }
   public PieChartModel getModel1() {
      return model1;
  }
}
