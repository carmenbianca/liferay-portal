/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.constants;

import java.util.Objects;

/**
 * @author Jürgen Kappler
 * @author Preston Crary
 */
public class FragmentConstants {

	public static final String RESOURCE_NAME = "com.liferay.fragment";

	public static final String SERVICE_NAME = "com.liferay.fragment";

	public static final int TYPE_COMPONENT = 1;

	public static final String TYPE_COMPONENT_LABEL = "component";

	public static final int TYPE_SECTION = 0;

	public static final String TYPE_SECTION_LABEL = "section";

	public static int getTypeFromLabel(String label) {
		if (Objects.equals(TYPE_COMPONENT_LABEL, label)) {
			return TYPE_COMPONENT;
		}

		return TYPE_SECTION;
	}

	public static String getTypeLabel(int type) {
		if (type == TYPE_COMPONENT) {
			return TYPE_COMPONENT_LABEL;
		}

		return TYPE_SECTION_LABEL;
	}

}