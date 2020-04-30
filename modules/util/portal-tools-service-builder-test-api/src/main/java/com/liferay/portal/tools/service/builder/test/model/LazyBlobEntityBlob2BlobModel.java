/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the blob2 column in LazyBlobEntity.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntity
 * @generated
 */
public class LazyBlobEntityBlob2BlobModel {

	public LazyBlobEntityBlob2BlobModel() {
	}

	public LazyBlobEntityBlob2BlobModel(long lazyBlobEntityId) {
		_lazyBlobEntityId = lazyBlobEntityId;
	}

	public LazyBlobEntityBlob2BlobModel(long lazyBlobEntityId, Blob blob2Blob) {
		_lazyBlobEntityId = lazyBlobEntityId;
		_blob2Blob = blob2Blob;
	}

	public long getLazyBlobEntityId() {
		return _lazyBlobEntityId;
	}

	public void setLazyBlobEntityId(long lazyBlobEntityId) {
		_lazyBlobEntityId = lazyBlobEntityId;
	}

	public Blob getBlob2Blob() {
		return _blob2Blob;
	}

	public void setBlob2Blob(Blob blob2Blob) {
		_blob2Blob = blob2Blob;
	}

	private long _lazyBlobEntityId;
	private Blob _blob2Blob;

}