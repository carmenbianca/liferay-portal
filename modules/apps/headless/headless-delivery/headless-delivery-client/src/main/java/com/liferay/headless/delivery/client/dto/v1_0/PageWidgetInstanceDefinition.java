/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.PageWidgetInstanceDefinitionSerDes;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class PageWidgetInstanceDefinition implements Cloneable {

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

	public void setWidget(
		UnsafeSupplier<Widget, Exception> widgetUnsafeSupplier) {

		try {
			widget = widgetUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Widget widget;

	public Map<String, Object> getWidgetConfig() {
		return widgetConfig;
	}

	public void setWidgetConfig(Map<String, Object> widgetConfig) {
		this.widgetConfig = widgetConfig;
	}

	public void setWidgetConfig(
		UnsafeSupplier<Map<String, Object>, Exception>
			widgetConfigUnsafeSupplier) {

		try {
			widgetConfig = widgetConfigUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Map<String, Object> widgetConfig;

	@Override
	public PageWidgetInstanceDefinition clone()
		throws CloneNotSupportedException {

		return (PageWidgetInstanceDefinition)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PageWidgetInstanceDefinition)) {
			return false;
		}

		PageWidgetInstanceDefinition pageWidgetInstanceDefinition =
			(PageWidgetInstanceDefinition)object;

		return Objects.equals(
			toString(), pageWidgetInstanceDefinition.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PageWidgetInstanceDefinitionSerDes.toJSON(this);
	}

}