/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.display.context;

import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sergio González
 */
public class BlogImagesDisplayContext {

	public BlogImagesDisplayContext(
		LiferayPortletRequest liferayPortletRequest) {

		_liferayPortletRequest = liferayPortletRequest;

		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
	}

	public void populateResults(SearchContainer searchContainer)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		Folder attachmentsFolder =
			BlogsEntryLocalServiceUtil.addAttachmentsFolder(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId());

		int total = 0;
		List results = null;

		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");

		if (Validator.isNull(keywords)) {
			total = PortletFileRepositoryUtil.getPortletFileEntriesCount(
				themeDisplay.getScopeGroupId(),
				attachmentsFolder.getFolderId());

			searchContainer.setTotal(total);

			results = PortletFileRepositoryUtil.getPortletFileEntries(
				themeDisplay.getScopeGroupId(), attachmentsFolder.getFolderId(),
				WorkflowConstants.STATUS_APPROVED, searchContainer.getStart(),
				searchContainer.getEnd(),
				searchContainer.getOrderByComparator());

			searchContainer.setResults(results);
		}
		else {
			SearchContext searchContext = SearchContextFactory.getInstance(
				_httpServletRequest);

			searchContext.setEnd(searchContainer.getEnd());
			searchContext.setFolderIds(
				new long[] {attachmentsFolder.getFolderId()});
			searchContext.setStart(searchContainer.getStart());

			String orderByCol = ParamUtil.getString(
				_httpServletRequest, "orderByCol", "title");
			String orderByType = ParamUtil.getString(
				_httpServletRequest, "orderByType", "asc");

			Sort sort = new Sort(
				orderByCol, !StringUtil.equalsIgnoreCase(orderByType, "asc"));

			searchContext.setSorts(sort);

			Folder folder = DLAppLocalServiceUtil.getFolder(
				attachmentsFolder.getFolderId());

			Hits hits = PortletFileRepositoryUtil.searchPortletFileEntries(
				folder.getRepositoryId(), searchContext);

			total = hits.getLength();

			Document[] docs = hits.getDocs();

			results = new ArrayList<>();

			for (Document doc : docs) {
				long fileEntryId = GetterUtil.getLong(
					doc.get(Field.ENTRY_CLASS_PK));

				FileEntry fileEntry = null;

				try {
					fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);

					results.add(fileEntry);
				}
				catch (Exception exception) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							StringBundler.concat(
								"Documents and Media search index is stale ",
								"and contains file entry ", fileEntryId));
					}
				}
			}

			searchContainer.setTotal(total);
			searchContainer.setResults(results);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BlogImagesDisplayContext.class);

	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;

}