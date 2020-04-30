/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.facet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Raymond Augé
 * @author Tibor Lipusz
 */
@Component(
	immediate = true,
	property = "class.name=com.liferay.portal.search.internal.facet.ModifiedFacetImpl",
	service = FacetProcessor.class
)
public class ModifiedFacetProcessor extends RangeFacetProcessor {
}