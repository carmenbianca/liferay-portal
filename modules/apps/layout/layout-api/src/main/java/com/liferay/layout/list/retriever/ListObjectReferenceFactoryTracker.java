/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.list.retriever;

/**
 * @author Eudaldo Alonso
 */
public interface ListObjectReferenceFactoryTracker {

	public ListObjectReferenceFactory getListObjectReference(String type);

}