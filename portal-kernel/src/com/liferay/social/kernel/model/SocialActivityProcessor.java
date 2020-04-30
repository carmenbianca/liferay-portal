/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.model;

/**
 * @author Zsolt Berentey
 */
public interface SocialActivityProcessor {

	public void processActivity(SocialActivity activity);

}