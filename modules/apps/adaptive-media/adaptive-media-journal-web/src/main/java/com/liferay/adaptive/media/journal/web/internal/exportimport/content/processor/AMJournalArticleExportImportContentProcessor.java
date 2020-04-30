/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.journal.web.internal.exportimport.content.processor;

import com.liferay.exportimport.content.processor.ExportImportContentProcessor;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.StagedModel;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = {
		"model.class.name=com.liferay.journal.model.JournalArticle",
		"service.ranking:Integer=100"
	},
	service = ExportImportContentProcessor.class
)
public class AMJournalArticleExportImportContentProcessor
	implements ExportImportContentProcessor<String> {

	@Override
	public String replaceExportContentReferences(
			PortletDataContext portletDataContext, StagedModel stagedModel,
			String content, boolean exportReferencedContent,
			boolean escapeContent)
		throws Exception {

		String replacedContent =
			_journalArticleExportImportContentProcessor.
				replaceExportContentReferences(
					portletDataContext, stagedModel, content,
					exportReferencedContent, escapeContent);

		return _amJournalArticleContentHTMLReplacer.replace(
			replacedContent,
			html ->
				_htmlExportImportContentProcessor.
					replaceExportContentReferences(
						portletDataContext, stagedModel, html,
						exportReferencedContent, escapeContent));
	}

	@Override
	public String replaceImportContentReferences(
			PortletDataContext portletDataContext, StagedModel stagedModel,
			String content)
		throws Exception {

		String replacedContent =
			_journalArticleExportImportContentProcessor.
				replaceImportContentReferences(
					portletDataContext, stagedModel, content);

		return _amJournalArticleContentHTMLReplacer.replace(
			replacedContent,
			html ->
				_htmlExportImportContentProcessor.
					replaceImportContentReferences(
						portletDataContext, stagedModel, html));
	}

	@Override
	public void validateContentReferences(long groupId, String content)
		throws PortalException {

		_journalArticleExportImportContentProcessor.validateContentReferences(
			groupId, content);

		try {
			_amJournalArticleContentHTMLReplacer.replace(
				content,
				html -> {
					_htmlExportImportContentProcessor.validateContentReferences(
						groupId, html);

					return html;
				});
		}
		catch (Exception exception) {
			throw new PortalException(exception);
		}
	}

	@Reference
	private AMJournalArticleContentHTMLReplacer
		_amJournalArticleContentHTMLReplacer;

	@Reference(target = "(adaptive.media.format=html)")
	private ExportImportContentProcessor<String>
		_htmlExportImportContentProcessor;

	@Reference(
		target = "(&(model.class.name=com.liferay.journal.model.JournalArticle)(!(component.name=com.liferay.adaptive.media.journal.web.internal.exportimport.content.processor.AMJournalArticleExportImportContentProcessor)))"
	)
	private ExportImportContentProcessor<String>
		_journalArticleExportImportContentProcessor;

}