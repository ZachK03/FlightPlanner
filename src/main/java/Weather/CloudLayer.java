package Weather;

import java.text.NumberFormat;
import java.util.Locale;

public class CloudLayer {
    public enum LayerType {
        CLEAR,
        FEW,
        SCATTERED,
        BROKEN,
        OVERCAST;
    }

    private LayerType m_layerType;
    private int m_altitude;

    public LayerType getM_layerType() {
        return m_layerType;
    }

    public void setM_layerType(LayerType m_layerType) {
        this.m_layerType = m_layerType;
    }

    public int getM_altitude() {
        return m_altitude;
    }

    public void setM_altitude(int m_altitude) {
        this.m_altitude = m_altitude;
    }

    public CloudLayer(String type, int alt) {
        m_altitude = alt;
        switch (type) {
            case "SKC":
                m_layerType = LayerType.CLEAR;
                break;
            case "CLR":
                m_layerType = LayerType.CLEAR;
                break;
            case "FEW":
                m_layerType = LayerType.FEW;
                break;
            case "SCT":
                m_layerType = LayerType.SCATTERED;
                break;
            case "BKN":
                m_layerType = LayerType.BROKEN;
                break;
            case "OVC":
                m_layerType = LayerType.OVERCAST;
                break;
        }
    }

    public String toString() {
        String out = "Sky conditions: ";
        if(m_layerType == LayerType.CLEAR)
            out += "Clear";
        if(m_layerType == LayerType.FEW)
            out += "Few";
        if(m_layerType == LayerType.SCATTERED)
            out += "Scattered";
        if(m_layerType == LayerType.BROKEN)
            out += "Broken";
        if(m_layerType == LayerType.OVERCAST)
            out += "Overcast";
        if(m_layerType != LayerType.CLEAR) {
            out += " at " + NumberFormat.getNumberInstance(Locale.US).format(m_altitude) + " ft AGL";
        }
        return out;
    }
}
