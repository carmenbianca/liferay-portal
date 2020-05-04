/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.jsp.compiler.internal;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

/**
 * @author Raymond Augé
 * @author Shuyang Zhou
 */
public class BundleJavaFileManager
	extends ForwardingJavaFileManager<JavaFileManager> {

	public static final String OPT_VERBOSE = "-verbose";

	public BundleJavaFileManager(
		ClassLoader classLoader, JavaFileManager javaFileManager,
		List<JavaFileObjectResolver> javaFileObjectResolvers) {

		super(javaFileManager);

		_classLoader = classLoader;
		_javaFileObjectResolvers = javaFileObjectResolvers;
	}

	@Override
	public ClassLoader getClassLoader(Location location) {
		if (location != StandardLocation.CLASS_PATH) {
			return fileManager.getClassLoader(location);
		}

		return _classLoader;
	}

	@Override
	public String inferBinaryName(Location location, JavaFileObject file) {
		if ((location == StandardLocation.CLASS_PATH) &&
			(file instanceof BaseJavaFileObject)) {

			BaseJavaFileObject baseJavaFileObject = (BaseJavaFileObject)file;

			if (_log.isInfoEnabled()) {
				_log.info("Inferring binary name from " + baseJavaFileObject);
			}

			return baseJavaFileObject.getClassName();
		}

		return fileManager.inferBinaryName(location, file);
	}

	@Override
	public Iterable<JavaFileObject> list(
			Location location, String packageName,
			Set<JavaFileObject.Kind> kinds, boolean recurse)
		throws IOException {

		if (!kinds.contains(JavaFileObject.Kind.CLASS)) {
			return Collections.emptyList();
		}

		if ((location == StandardLocation.CLASS_PATH) && _log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(9);

			sb.append("List for {kinds=");
			sb.append(_kinds);
			sb.append(", location=");
			sb.append(location);
			sb.append(", packageName=");
			sb.append(packageName);
			sb.append(", recurse=");
			sb.append(recurse);
			sb.append(StringPool.CLOSE_CURLY_BRACE);

			_log.info(sb.toString());
		}

		String packagePath = StringUtil.replace(
			packageName, CharPool.PERIOD, CharPool.SLASH);

		if (!packageName.startsWith("java.") &&
			(location == StandardLocation.CLASS_PATH)) {

			for (JavaFileObjectResolver javaFileObjectResolver :
					_javaFileObjectResolvers) {

				Collection<JavaFileObject> javaFileObjects =
					javaFileObjectResolver.resolveClasses(recurse, packagePath);

				if (!javaFileObjects.isEmpty()) {
					return javaFileObjects;
				}
			}
		}

		return fileManager.list(location, packagePath, _kinds, recurse);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BundleJavaFileManager.class);

	private static final Set<JavaFileObject.Kind> _kinds = EnumSet.of(
		JavaFileObject.Kind.CLASS);

	private final ClassLoader _classLoader;
	private final List<JavaFileObjectResolver> _javaFileObjectResolvers;

}