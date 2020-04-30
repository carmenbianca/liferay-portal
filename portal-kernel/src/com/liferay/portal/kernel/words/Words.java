/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.words;

import com.liferay.portal.kernel.jazzy.InvalidWord;

import java.util.List;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Shinn Lok
 */
@ProviderType
public interface Words {

	public List<InvalidWord> checkSpelling(String text);

	public List<String> getDictionaryList();

	public Set<String> getDictionarySet();

	public String getRandomWord();

	public boolean isDictionaryWord(String word);

}