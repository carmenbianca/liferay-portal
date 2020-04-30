/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.change.tracking.resolver;

import com.liferay.change.tracking.resolver.ConstraintResolver;
import com.liferay.change.tracking.resolver.helper.ConstraintResolverHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.comparator.ArticleVersionComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.MathUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(service = ConstraintResolver.class)
public class JournalArticleVersionConstraintResolver
	implements ConstraintResolver<JournalArticle> {

	@Override
	public String getConflictDescriptionKey() {
		return "duplicate-article-version";
	}

	@Override
	public Class<JournalArticle> getModelClass() {
		return JournalArticle.class;
	}

	@Override
	public String getResolutionDescriptionKey() {
		return "the-article-version-was-updated-to-latest";
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundleUtil.getBundle(locale, "com.liferay.journal.lang");
	}

	@Override
	public String[] getUniqueIndexColumnNames() {
		return new String[] {"groupId", "articleId", "version"};
	}

	@Override
	public void resolveConflict(
			ConstraintResolverHelper<JournalArticle> constraintResolverHelper)
		throws PortalException {

		JournalArticle ctArticle = constraintResolverHelper.getSourceCTModel();

		double latestVersion = constraintResolverHelper.getInTarget(
			() -> {
				JournalArticle latestProductionArticle =
					_journalArticleLocalService.getLatestArticle(
						ctArticle.getResourcePrimKey(),
						WorkflowConstants.STATUS_ANY, false);

				return latestProductionArticle.getVersion();
			});

		List<JournalArticle> articles = _journalArticleLocalService.getArticles(
			ctArticle.getGroupId(), ctArticle.getArticleId(), QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, new ArticleVersionComparator());

		for (JournalArticle article : articles) {
			if (article.getCtCollectionId() == ctArticle.getCtCollectionId()) {
				latestVersion = MathUtil.format(latestVersion + 0.1, 1, 1);

				article.setVersion(latestVersion);

				_journalArticleLocalService.updateJournalArticle(article);
			}
		}
	}

	@Reference
	private JournalArticleLocalService _journalArticleLocalService;

}