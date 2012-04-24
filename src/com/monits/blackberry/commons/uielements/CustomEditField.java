/*
 * Copyright 2012 Monits
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.monits.blackberry.commons.uielements;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.monits.blackberry.commons.service.ServiceLocator;

/**
 * Custom edit field.
 *
 */
public class CustomEditField extends BasicEditField {
	
	private static int DEFAULT_FONT_SIZE = 35;
	
	/**
	 * Constructor.
	 */
	public CustomEditField(){
		
		super(EditField.NO_NEWLINE);
		
		this.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
		int fontSize = ServiceLocator.getScreenTypeService().getNewSize(DEFAULT_FONT_SIZE); 
		
		this.setFont(this.getFont().derive(this.getFont().getStyle(), fontSize));
	}
	
	protected void layout(int width, int height) {
		super.layout(width, height);
		setExtent(getPreferredWidth(), getPreferredHeight());
	}
	
	public int getPreferredWidth() {
		return Display.getWidth() - ServiceLocator.getScreenTypeService().getNewSize(60);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.LIGHTGRAY);
		g.drawLine(0, 0, getWidth(), 0);
		g.drawLine(0, 1, getWidth(), 1);
		
		g.setColor(Color.BLACK);
		g.setDrawingStyle(DrawStyle.HCENTER, true);
		super.paint(g);
	}

}
