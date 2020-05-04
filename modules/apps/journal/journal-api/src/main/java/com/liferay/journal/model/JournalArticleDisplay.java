/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.model;

import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public interface JournalArticleDisplay extends Serializable {

	public String getArticleDisplayImageURL(ThemeDisplay themeDisplay);

	public String getArticleId();

	public String[] getAvailableLocales();

	public long getCompanyId();

	public String getContent();

	public int getCurrentPage();

	public String getDDMStructureKey();

	public String getDDMTemplateKey();

	public String getDescription();

	public long getGroupId();

	public long getId();

	public int getNumberOfPages();

	public long getResourcePrimKey();

	public long getSmallImageId();

	public String getSmallImageURL();

	public String getTitle();

	public String getUrlTitle();

	public long getUserId();

	public double getVersion();

	public boolean isCacheable();

	public boolean isPaginate();

	public boolean isSmallImage();

	public void setCacheable(boolean cacheable);

	public void setContent(String content);

	public void setCurrentPage(int currentPage);

	public void setDDMStructureKey(String ddmStructureKey);

	public void setDDMTemplateKey(String ddmTemplateKey);

	public void setNumberOfPages(int numberOfPages);

	public void setPaginate(boolean paginate);

	public void setSmallImage(boolean smallImage);

	public void setSmallImageId(long smallImageId);

	public void setSmallImageURL(String smallImageURL);

}