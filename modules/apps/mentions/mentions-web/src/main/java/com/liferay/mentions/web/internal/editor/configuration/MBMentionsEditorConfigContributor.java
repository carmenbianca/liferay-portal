/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.web.internal.editor.configuration;

import com.liferay.message.boards.constants.MBPortletKeys;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	property = {
		"editor.config.key=bodyEditor", "editor.config.key=replyMBEditor",
		"editor.name=alloyeditor", "editor.name=alloyeditor_bbcode",
		"editor.name=ckeditor", "editor.name=ckeditor_bbcode",
		"javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS,
		"javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS_ADMIN,
		"service.ranking:Integer=10"
	},
	service = EditorConfigContributor.class
)
public class MBMentionsEditorConfigContributor
	extends BaseMentionsEditorConfigContributor {
}