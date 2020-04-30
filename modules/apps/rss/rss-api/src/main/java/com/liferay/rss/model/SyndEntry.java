/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.model;

import java.util.Date;
import java.util.List;

/**
 * @author Shuyang Zhou
 */
public interface SyndEntry {

	public String getAuthor();

	public SyndContent getDescription();

	public List<SyndEnclosure> getEnclosures();

	public String getLink();

	public List<SyndLink> getLinks();

	public Date getPublishedDate();

	public String getTitle();

	public Date getUpdatedDate();

	public String getUri();

	public void setAuthor(String author);

	public void setDescription(SyndContent description);

	public void setEnclosures(List<SyndEnclosure> syndEnclosures);

	public void setLink(String link);

	public void setLinks(List<SyndLink> syndLinks);

	public void setPublishedDate(Date publishedDate);

	public void setTitle(String title);

	public void setUpdatedDate(Date updatedDate);

	public void setUri(String uri);

}