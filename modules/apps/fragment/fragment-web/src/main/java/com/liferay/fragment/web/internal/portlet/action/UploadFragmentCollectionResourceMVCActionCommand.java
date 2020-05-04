/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.portlet.action;

import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.web.internal.upload.FragmentCollectionResourceUploadFileEntryHandler;
import com.liferay.item.selector.ItemSelectorUploadResponseHandler;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.upload.UploadHandler;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FragmentPortletKeys.FRAGMENT,
		"mvc.command.name=/fragment/upload_fragment_collection_resource"
	},
	service = MVCActionCommand.class
)
public class UploadFragmentCollectionResourceMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		_uploadHandler.upload(
			_fragmentCollectionResourceUploadFileEntryHandler,
			_itemSelectorUploadResponseHandler, actionRequest, actionResponse);
	}

	@Reference
	private FragmentCollectionResourceUploadFileEntryHandler
		_fragmentCollectionResourceUploadFileEntryHandler;

	@Reference
	private ItemSelectorUploadResponseHandler
		_itemSelectorUploadResponseHandler;

	@Reference
	private UploadHandler _uploadHandler;

}