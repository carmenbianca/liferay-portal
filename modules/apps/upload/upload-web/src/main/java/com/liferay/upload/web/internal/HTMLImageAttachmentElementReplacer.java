/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload.web.internal;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.editor.EditorConstants;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.upload.AttachmentElementReplacer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 * @author Jürgen Kappler
 */
@Component(
	property = {"format=html", "html.tag.name=img"},
	service = AttachmentElementReplacer.class
)
public class HTMLImageAttachmentElementReplacer
	implements AttachmentElementReplacer {

	@Override
	public String replace(String originalImgHtmlElement, FileEntry fileEntry) {
		Element element = _toElement(originalImgHtmlElement);

		String fileEntryURL = _portletFileRepository.getPortletFileEntryURL(
			null, fileEntry, StringPool.BLANK);

		element.attr("src", fileEntryURL);

		element.removeAttr(EditorConstants.ATTRIBUTE_DATA_IMAGE_ID);

		return element.toString();
	}

	@Reference(unbind = "-")
	protected void setPortletFileRepository(
		PortletFileRepository portletFileRepository) {

		_portletFileRepository = portletFileRepository;
	}

	private Element _toElement(String originalImgTag) {
		Document document = Jsoup.parseBodyFragment(originalImgTag);

		Document.OutputSettings outputSettings = new Document.OutputSettings();

		outputSettings.prettyPrint(false);
		outputSettings.syntax(Document.OutputSettings.Syntax.xml);

		document.outputSettings(outputSettings);

		Element bodyElement = document.body();

		return bodyElement.child(0);
	}

	private PortletFileRepository _portletFileRepository;

}