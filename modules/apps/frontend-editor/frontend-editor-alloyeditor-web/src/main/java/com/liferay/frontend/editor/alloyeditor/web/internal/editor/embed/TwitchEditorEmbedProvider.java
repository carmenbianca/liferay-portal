/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.editor.alloyeditor.web.internal.editor.embed;

import com.liferay.frontend.editor.embed.EditorEmbedProvider;
import com.liferay.frontend.editor.embed.EditorEmbedProviderTypeConstants;
import com.liferay.petra.string.StringBundler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = "type=" + EditorEmbedProviderTypeConstants.VIDEO,
	service = EditorEmbedProvider.class
)
public class TwitchEditorEmbedProvider implements EditorEmbedProvider {

	@Override
	public String getId() {
		return "twitch";
	}

	@Override
	public String getTpl() {
		return StringBundler.concat(
			"<iframe allowfullscreen=\"true\" frameborder=\"0\" ",
			"height=\"315\" ",
			"src=\"https://player.twitch.tv/?autoplay=false&video={embedId}\" ",
			"scrolling=\"no\" width=\"560\" ></iframe>");
	}

	@Override
	public String[] getURLSchemes() {
		return new String[] {
			"https?:\\/\\/(?:www\\.)?twitch.tv\\/videos\\/(\\S*)$"
		};
	}

}