/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the blob1 column in LazyBlobEntity.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntity
 * @generated
 */
public class LazyBlobEntityBlob1BlobModel {

	public LazyBlobEntityBlob1BlobModel() {
	}

	public LazyBlobEntityBlob1BlobModel(long lazyBlobEntityId) {
		_lazyBlobEntityId = lazyBlobEntityId;
	}

	public LazyBlobEntityBlob1BlobModel(long lazyBlobEntityId, Blob blob1Blob) {
		_lazyBlobEntityId = lazyBlobEntityId;
		_blob1Blob = blob1Blob;
	}

	public long getLazyBlobEntityId() {
		return _lazyBlobEntityId;
	}

	public void setLazyBlobEntityId(long lazyBlobEntityId) {
		_lazyBlobEntityId = lazyBlobEntityId;
	}

	public Blob getBlob1Blob() {
		return _blob1Blob;
	}

	public void setBlob1Blob(Blob blob1Blob) {
		_blob1Blob = blob1Blob;
	}

	private long _lazyBlobEntityId;
	private Blob _blob1Blob;

}