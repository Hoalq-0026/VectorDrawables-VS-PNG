package com.techdb.databindingobservable.vectordrawablevspng;

/**
 * Listener that notifies when a view has finishes drawing.
 */

public interface ViewRedrawnListener {

    /**
     * Called when the drawing of the view finished, with the duration of the draw.
     * @param miliseconds the time took to draw the view
     */
    void onDrawfinished(double miliseconds);
}
