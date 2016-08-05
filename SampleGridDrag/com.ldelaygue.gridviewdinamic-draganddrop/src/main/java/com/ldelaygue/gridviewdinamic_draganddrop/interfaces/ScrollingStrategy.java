package com.ldelaygue.gridviewdinamic_draganddrop.interfaces;


import com.ldelaygue.gridviewdinamic_draganddrop.classes.DinamicDragAndDropGridView;

public interface ScrollingStrategy {

	boolean performScrolling(final int x, final int y, final DinamicDragAndDropGridView view);

}
