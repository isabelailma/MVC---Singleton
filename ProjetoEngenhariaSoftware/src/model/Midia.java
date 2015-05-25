package model;

/**
 * Created by Isabela on 24/03/2015.
 */
public enum Midia {

    VHS, DVD, BLURAY;

    @Override
    public String toString() {
        switch(this) {
            case VHS: return "VHS";
            case DVD: return "DVD";
            case BLURAY: return "Bluray";
            default: return "unspecified";
        }
    }
}
