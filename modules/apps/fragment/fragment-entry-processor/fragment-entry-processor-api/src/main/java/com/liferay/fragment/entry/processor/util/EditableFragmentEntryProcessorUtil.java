/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.entry.processor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Jürgen Kappler
 */
public class EditableFragmentEntryProcessorUtil {

	public static Map<String, String> getEditableTypes(String html) {
		Map<String, String> editableTypes = new HashMap<>();

		Document document = Jsoup.parse(html);

		Elements elements = document.select(
			"lfr-editable,*[data-lfr-editable-id]");

		elements.forEach(
			element -> editableTypes.put(
				getElementId(element), getElementType(element)));

		return editableTypes;
	}

	public static String getElementId(Element element) {
		if (Objects.equals(element.tagName(), "lfr-editable")) {
			return element.attr("id");
		}

		return element.attr("data-lfr-editable-id");
	}

	public static String getElementType(Element element) {
		if (Objects.equals(element.tagName(), "lfr-editable")) {
			return element.attr("type");
		}

		return element.attr("data-lfr-editable-type");
	}

}