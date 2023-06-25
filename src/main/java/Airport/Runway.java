package Airport;

public class Runway {
    private String[] runwayDirections = new String[2];
    private int length;
    private int width;
    private String surfaceType;

    public String[] getRunwayDirections() {
        return runwayDirections;
    }

    public void setRunwayDirections(String[] runwayDirections) {
        this.runwayDirections = runwayDirections;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public boolean hasRunway(int direction) {
        direction = direction / 10;
        String tempDir;
        if(direction < 10)
            tempDir = "0" + String.valueOf(direction);
        else
            tempDir = String.valueOf(direction);
        for(String runwayDir : runwayDirections) {
            if(runwayDir.contains(tempDir)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String out = "";
        out += "  Runway: " + getRunwayDirections()[0] + "/" + getRunwayDirections()[1] + "\n    Length: " + getLength() + " ft\n    Width: " + getWidth() + " ft\n";
        switch(getSurfaceType()) {
            case "A":
                out += "    Surface: Asphalt\n";
                break;
            case "C":
                out += "    Surface: Concrete\n";
                break;
        }
        return out;
    }
}
