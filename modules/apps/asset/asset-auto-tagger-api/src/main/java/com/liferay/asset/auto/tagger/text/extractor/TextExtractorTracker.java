/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.text.extractor;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public interface TextExtractorTracker {

	public TextExtractor getTextExtractor(String className);

	public List<TextExtractor> getTextExtractors();

}