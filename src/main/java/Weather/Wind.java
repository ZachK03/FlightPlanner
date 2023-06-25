package Weather;

public class Wind {
    private int m_direction;
    private int m_speed;
    private boolean m_isGusting = false;
    private int m_gustSpeed;
    private boolean m_isVariable = false;

    public boolean isM_isVariable() {
        return m_isVariable;
    }
    public void setM_isVariable(boolean m_isVariable) {
        this.m_isVariable = m_isVariable;
    }
    public int getM_direction() {
        return m_direction;
    }
    public void setM_direction(int m_direction) {
        this.m_direction = m_direction;
    }
    public int getM_speed() {
        return m_speed;
    }
    public void setM_speed(int m_speed) {
        this.m_speed = m_speed;
    }
    public boolean isM_isGusting() {
        return m_isGusting;
    }
    public void setM_isGusting(boolean m_isGusting) {
        this.m_isGusting = m_isGusting;
    }
    public int getM_gustSpeed() {
        return m_gustSpeed;
    }
    public void setM_gustSpeed(int m_gustSpeed) {
        this.m_gustSpeed = m_gustSpeed;
    }

    public Wind(int direction, int speed) {
        m_direction = direction;
        m_speed = speed;
    }
    public Wind(int direction, int speed, int gustSpeed) {
        m_direction = direction;
        m_speed = speed;
        m_isGusting = true;
        m_gustSpeed = gustSpeed;
    }

    public String toString() {
        String out = "Wind direction: ";
        if(m_isVariable)
            out += "Variable\n";
        else {
            if(m_direction < 100)
                out += "0";
            out += m_direction + "° true\n";
        }
        out += "Wind strength: " + m_speed + " kts";
        if(m_isGusting)
            out += "\nGusting: " + m_gustSpeed + "kts";
        return out;
    }
}
