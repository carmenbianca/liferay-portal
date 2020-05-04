/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.upload.UploadHandler;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.web.internal.upload.PageAttachmentWikiUploadFileEntryHandler;
import com.liferay.wiki.web.internal.upload.PageAttachmentWikiUploadResponseHandler;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Roberto Díaz
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WikiPortletKeys.WIKI,
		"mvc.command.name=/wiki/upload_page_attachment"
	},
	service = MVCActionCommand.class
)
public class UploadPageAttachmentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		_uploadHandler.upload(
			_pageAttachmentWikiUploadFileEntryHandler,
			_pageAttachmentWikiUploadResponseHandler, actionRequest,
			actionResponse);
	}

	@Reference
	private PageAttachmentWikiUploadFileEntryHandler
		_pageAttachmentWikiUploadFileEntryHandler;

	@Reference
	private PageAttachmentWikiUploadResponseHandler
		_pageAttachmentWikiUploadResponseHandler;

	@Reference
	private UploadHandler _uploadHandler;

}