package ControladorA;

import DAOA.DaoElementosA;
import ModeloA.ElementoA;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

public class BarServletA extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("image/png");
            OutputStream outputStream = response.getOutputStream();
            JFreeChart chart = getChart();
            int width = 500;
            int height = 350;
            ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BarServletA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JFreeChart getChart() throws URISyntaxException {

        ArrayList<ElementoA> arr = new ArrayList<ElementoA>();
        DaoElementosA daoE = new DaoElementosA();
        arr = daoE.cantidadElementosPorArea();
        double[][] data = new double[1][arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            data[0][i] = arr.get(i).getCantidadDisponible();
        }

        CategoryDataset category = DatasetUtilities.createCategoryDataset(
                "Series",
                "Category",
                data
        );

        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de elementos por área", // chart title
                "Area", // domain axis label
                "Elementos", // range axis label
                category, // data
                PlotOrientation.VERTICAL, // the plot orientation
                false, // include legend
                true,
                false
        );

        chart.setBackgroundPaint(Color.lightGray);

        // get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        CategoryItemRenderer renderer = new CustomRendererA(
                new Paint[]{Color.red, Color.blue, Color.green,
                    Color.yellow, Color.WHITE, Color.cyan,
                    Color.magenta, Color.blue}
        );

        renderer.setItemLabelsVisible(true);
        ItemLabelPosition p = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 45.0
        );
        renderer.setPositiveItemLabelPosition(p);
        plot.setRenderer(renderer);

        // change the margin at the top of the range axis...
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.15);
        rangeAxis.setUpperMargin(0.15);

        return chart;

    }

}
