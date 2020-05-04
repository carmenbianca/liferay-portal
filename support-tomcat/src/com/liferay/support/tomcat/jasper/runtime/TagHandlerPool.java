/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.support.tomcat.jasper.runtime;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import org.apache.jasper.Constants;

/**
 * <p>
 * See https://issues.liferay.com/browse/LPS-19130.
 * </p>
 *
 * @author Shuyang Zhou
 * @see    com.liferay.portal.osgi.web.servlet.jsp.compiler.internal.JspTagHandlerPool
 */
public class TagHandlerPool extends org.apache.jasper.runtime.TagHandlerPool {

	@Override
	@SuppressWarnings("rawtypes")
	public Tag get(Class tagClass) throws JspException {
		Tag tag = _tags.poll();

		if (tag == null) {
			try {
				tag = (Tag)tagClass.newInstance();
			}
			catch (Exception exception) {
				throw new JspException(exception);
			}
		}
		else {
			_counter.getAndDecrement();
		}

		return tag;
	}

	@Override
	public void release() {
		Tag tag = null;

		while ((tag = _tags.poll()) != null) {
			tag.release();
		}
	}

	@Override
	public void reuse(Tag tag) {
		if (_counter.get() < _maxSize) {
			_counter.getAndIncrement();

			_tags.offer(tag);
		}
		else {
			tag.release();
		}
	}

	@Override
	protected void init(ServletConfig config) {
		_maxSize = GetterUtil.getInteger(
			getOption(config, OPTION_MAXSIZE, null), Constants.MAX_POOL_SIZE);
	}

	private final AtomicInteger _counter = new AtomicInteger();
	private int _maxSize;
	private final Queue<Tag> _tags = new ConcurrentLinkedQueue<>();

}