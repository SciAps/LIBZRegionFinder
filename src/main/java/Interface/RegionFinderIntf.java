/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.sciaps.common.SpectrumShotItem;
import org.jfree.chart.plot.IntervalMarker;

/**
 *
 * @author jchen
 */
public interface RegionFinderIntf {

    void doAddMarker(IntervalMarker marker);

    void doAddMarker(IntervalMarker[] marker);

    void doRemoveMarker(IntervalMarker marker);

    void doShowShotXYSeries(SpectrumShotItem item);

    void doHideShotXYSeries(SpectrumShotItem item);

    void doDeleteShotXYSeries(SpectrumShotItem item);

    void doSpectrumAnalysisLayout(SpectrumShotItem spectrumShotItem);

    double getIntensityOfLine(int type, double waveLength, double regionWidth);
}
