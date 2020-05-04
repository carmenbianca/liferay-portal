/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.suggest.SpellCheckIndexWriter;

/**
 * @author Michael C. Han
 */
public abstract class BaseIndexWriter
	implements IndexWriter, SpellCheckIndexWriter {

	@Override
	public void clearQuerySuggestionDictionaryIndexes(
			SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.clearQuerySuggestionDictionaryIndexes(
			searchContext);
	}

	@Override
	public void clearSpellCheckerDictionaryIndexes(SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.clearSpellCheckerDictionaryIndexes(
			searchContext);
	}

	/**
	 * @throws SearchException
	 */
	@Override
	public void commit(SearchContext searchContext) throws SearchException {
	}

	@Override
	public void indexKeyword(
			SearchContext searchContext, float weight, String keywordType)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.indexKeyword(searchContext, weight, keywordType);
	}

	@Override
	public void indexQuerySuggestionDictionaries(SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.indexQuerySuggestionDictionaries(searchContext);
	}

	@Override
	public void indexQuerySuggestionDictionary(SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.indexQuerySuggestionDictionary(searchContext);
	}

	@Override
	public void indexSpellCheckerDictionaries(SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.indexSpellCheckerDictionaries(searchContext);
	}

	@Override
	public void indexSpellCheckerDictionary(SearchContext searchContext)
		throws SearchException {

		if (_spellCheckIndexWriter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("No spell check index writer configured");
			}

			return;
		}

		_spellCheckIndexWriter.indexSpellCheckerDictionary(searchContext);
	}

	public void setSpellCheckIndexWriter(
		SpellCheckIndexWriter spellCheckIndexWriter) {

		_spellCheckIndexWriter = spellCheckIndexWriter;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseIndexWriter.class);

	private SpellCheckIndexWriter _spellCheckIndexWriter;

}