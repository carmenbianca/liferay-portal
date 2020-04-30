/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.util;

import java.util.List;

/**
 * @author Adolfo Pérez
 */
public interface SocialRelationTypes {

	public List<Integer> getAllSocialRelationTypes();

	public String getTypeLabel(int type);

	public boolean isTypeBi(int type);

	public boolean isTypeUni(int type);

}