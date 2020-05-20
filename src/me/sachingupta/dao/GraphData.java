package me.sachingupta.dao;

import java.util.Objects;

public class GraphData {
    private String label;
    private String groupLabel;
    private double value;

    public GraphData(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public GraphData(String label, String groupLabel, double value) {
        this.label = label;
        this.groupLabel = groupLabel;
        this.value = value;
    }

    public GraphData() {}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getGroupLabel() {
        return groupLabel;
    }

    public void setGroupLabel(String groupLabel) {
        this.groupLabel = groupLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphData graphData = (GraphData) o;
        return Double.compare(graphData.value, value) == 0 &&
                Objects.equals(label, graphData.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, groupLabel);
    }

    @Override
    public String toString() {
        return "GraphData{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
