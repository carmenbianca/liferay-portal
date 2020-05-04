/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.asset.auto.tagger.google.cloud.vision.internal.util;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;

/**
 * @author Alejandro Tardín
 */
public class GCloudVisionUtil {

	public static String getAnnotateImagePayload(FileEntry fileEntry)
		throws Exception {

		FileVersion fileVersion = fileEntry.getFileVersion();

		JSONObject jsonObject = JSONUtil.put(
			"requests",
			JSONUtil.put(
				JSONUtil.put(
					"features",
					JSONUtil.put(JSONUtil.put("type", "LABEL_DETECTION"))
				).put(
					"image",
					JSONUtil.put(
						"content",
						Base64.encode(
							FileUtil.getBytes(
								fileVersion.getContentStream(false))))
				)));

		return jsonObject.toString();
	}

}