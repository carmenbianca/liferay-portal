/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.web.internal.editor.configuration;

import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	property = {
		"editor.config.key=commentEditor", "editor.name=alloyeditor",
		"editor.name=ckeditor", "service.ranking:Integer=10"
	},
	service = EditorConfigContributor.class
)
public class CommentMentionsEditorConfigContributor
	extends BaseMentionsEditorConfigContributor {
}