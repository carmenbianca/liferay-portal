/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.io.exporter;

import com.liferay.dynamic.data.mapping.io.exporter.DDMFormInstanceRecordWriter;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class DDMFormInstanceRecordWriterTrackerImplTest {

	@Test
	public void testDeactivate() {
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl =
				new DDMFormInstanceRecordWriterTrackerImpl();

		addDDMFormInstanceRecordCSVWriter(
			ddmFormInstanceRecordWriterTrackerImpl);

		ddmFormInstanceRecordWriterTrackerImpl.deactivate();

		Map<String, String> ddmFormInstanceRecordWriterExtensions =
			ddmFormInstanceRecordWriterTrackerImpl.
				getDDMFormInstanceRecordWriterExtensions();

		Assert.assertTrue(ddmFormInstanceRecordWriterExtensions.isEmpty());
	}

	@Test
	public void testGetDDMFormInstanceRecordWriter() {
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl =
				new DDMFormInstanceRecordWriterTrackerImpl();

		addDDMFormInstanceRecordCSVWriter(
			ddmFormInstanceRecordWriterTrackerImpl);

		DDMFormInstanceRecordWriter ddmFormInstanceRecordWriter =
			ddmFormInstanceRecordWriterTrackerImpl.
				getDDMFormInstanceRecordWriter("csv");

		Assert.assertTrue(
			ddmFormInstanceRecordWriter instanceof
				DDMFormInstanceRecordCSVWriter);
	}

	@Test
	public void testGetDDMFormInstanceRecordWriterDefaultUpperCaseExtension() {
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl =
				new DDMFormInstanceRecordWriterTrackerImpl();

		addDDMFormInstanceRecordXMLWriter(
			ddmFormInstanceRecordWriterTrackerImpl);

		Map<String, String> ddmFormInstanceRecordWriterExtensions =
			ddmFormInstanceRecordWriterTrackerImpl.
				getDDMFormInstanceRecordWriterExtensions();

		Assert.assertEquals(
			"XML", ddmFormInstanceRecordWriterExtensions.get("xml"));
	}

	@Test
	public void testGetDDMFormInstanceRecordWriterTypes() {
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl =
				new DDMFormInstanceRecordWriterTrackerImpl();

		addDDMFormInstanceRecordCSVWriter(
			ddmFormInstanceRecordWriterTrackerImpl);
		addDDMFormInstanceRecordJSONWriter(
			ddmFormInstanceRecordWriterTrackerImpl);

		Map<String, String> ddmFormInstanceRecordWriterExtensions =
			ddmFormInstanceRecordWriterTrackerImpl.
				getDDMFormInstanceRecordWriterExtensions();

		Assert.assertEquals(
			"csv", ddmFormInstanceRecordWriterExtensions.get("csv"));
		Assert.assertEquals(
			"json", ddmFormInstanceRecordWriterExtensions.get("json"));
	}

	@Test
	public void testRemoveDDMFormInstanceRecordWriter() {
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl =
				new DDMFormInstanceRecordWriterTrackerImpl();

		addDDMFormInstanceRecordCSVWriter(
			ddmFormInstanceRecordWriterTrackerImpl);
		addDDMFormInstanceRecordJSONWriter(
			ddmFormInstanceRecordWriterTrackerImpl);

		DDMFormInstanceRecordWriter ddmFormInstanceRecordWriter =
			new DDMFormInstanceRecordCSVWriter();

		Map<String, Object> properties = HashMapBuilder.<String, Object>put(
			"ddm.form.instance.record.writer.extension", "csv"
		).put(
			"ddm.form.instance.record.writer.type", "csv"
		).build();

		ddmFormInstanceRecordWriterTrackerImpl.
			removeDDMFormInstanceRecordWriter(
				ddmFormInstanceRecordWriter, properties);

		ddmFormInstanceRecordWriter =
			ddmFormInstanceRecordWriterTrackerImpl.
				getDDMFormInstanceRecordWriter("csv");

		Assert.assertNull(ddmFormInstanceRecordWriter);
	}

	protected void addDDMFormInstanceRecordCSVWriter(
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl) {

		DDMFormInstanceRecordWriter ddmFormInstanceRecordWriter =
			new DDMFormInstanceRecordCSVWriter();

		Map<String, Object> properties = HashMapBuilder.<String, Object>put(
			"ddm.form.instance.record.writer.extension", "csv"
		).put(
			"ddm.form.instance.record.writer.type", "csv"
		).build();

		ddmFormInstanceRecordWriterTrackerImpl.addDDMFormInstanceRecordWriter(
			ddmFormInstanceRecordWriter, properties);
	}

	protected void addDDMFormInstanceRecordJSONWriter(
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl) {

		DDMFormInstanceRecordWriter ddmFormInstanceRecordWriter =
			new DDMFormInstanceRecordJSONWriter();

		Map<String, Object> properties = HashMapBuilder.<String, Object>put(
			"ddm.form.instance.record.writer.extension", "json"
		).put(
			"ddm.form.instance.record.writer.type", "json"
		).build();

		ddmFormInstanceRecordWriterTrackerImpl.addDDMFormInstanceRecordWriter(
			ddmFormInstanceRecordWriter, properties);
	}

	protected void addDDMFormInstanceRecordXMLWriter(
		DDMFormInstanceRecordWriterTrackerImpl
			ddmFormInstanceRecordWriterTrackerImpl) {

		DDMFormInstanceRecordWriter ddmFormInstanceRecordWriter =
			new DDMFormInstanceRecordXMLWriter();

		Map<String, Object> properties = HashMapBuilder.<String, Object>put(
			"ddm.form.instance.record.writer.type", "xml"
		).build();

		ddmFormInstanceRecordWriterTrackerImpl.addDDMFormInstanceRecordWriter(
			ddmFormInstanceRecordWriter, properties);
	}

}