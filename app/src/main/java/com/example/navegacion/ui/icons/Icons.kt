package com.example.navegacion.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HamburguesaIcon: ImageVector
    get() = Builder(
        name = "HamburguesaIcon",
        defaultWidth = 128.dp,
        defaultHeight = 128.dp,
        viewportWidth = 128f,
        viewportHeight = 128f
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            // Primer path del XML
            moveTo(100f, 127f)
            curveTo(107.7f, 127f, 114f, 120.7f, 114f, 113f)
            horizontalLineTo(106f)
            curveTo(106f, 116.3f, 103.3f, 119f, 100f, 119f)
            horizontalLineTo(28f)
            curveTo(24.7f, 119f, 22f, 116.3f, 22f, 113f)
            horizontalLineTo(14f)
            curveTo(14f, 120.7f, 20.3f, 127f, 28f, 127f)
            horizontalLineTo(100f)
            close()

            // Segundo path del XML
            moveTo(22f, 59f)
            curveTo(22f, 35.8f, 40.8f, 17f, 64f, 17f)
            reflectiveCurveTo(106f, 35.8f, 106f, 59f)
            horizontalLineTo(114f)
            curveTo(114f, 31.4f, 91.6f, 9f, 64f, 9f)
            reflectiveCurveTo(14f, 31.4f, 14f, 59f)
            horizontalLineTo(22f)
            close()

            // Tercer path del XML
            moveTo(108f, 67f)
            horizontalLineTo(93.3f)
            lineTo(79f, 81.3f)
            lineTo(64.7f, 67f)
            horizontalLineTo(20f)
            curveTo(9.5f, 67f, 1f, 75.5f, 1f, 86f)
            reflectiveCurveTo(9.5f, 105f, 20f, 105f)
            horizontalLineTo(108f)
            curveTo(118.5f, 105f, 127f, 96.5f, 127f, 86f)
            reflectiveCurveTo(118.5f, 67f, 108f, 67f)
            close()
            moveTo(108f, 97f)
            horizontalLineTo(20f)
            curveTo(13.9f, 97f, 9f, 92.1f, 9f, 86f)
            reflectiveCurveTo(13.9f, 75f, 20f, 75f)
            horizontalLineTo(61.3f)
            lineTo(79f, 92.7f)
            lineTo(96.7f, 75f)
            horizontalLineTo(108f)
            curveTo(114.1f, 75f, 119f, 79.9f, 119f, 86f)
            reflectiveCurveTo(114.1f, 97f, 108f, 97f)
            close()

            // Cuarto path del XML
            moveTo(36f, 51.3f)
            horizontalLineTo(44f)
            verticalLineTo(59.3f)
            horizontalLineTo(36f)
            close()

            // Quinto path del XML
            moveTo(56f, 33.3f)
            horizontalLineTo(64f)
            verticalLineTo(41.3f)
            horizontalLineTo(56f)
            close()
        }
    }.build()
val FriedChickenIcon: ImageVector
    get() = ImageVector.Builder(
        name = "ChickenWingsIcon",
        defaultWidth = 512.dp,
        defaultHeight = 512.dp,
        viewportWidth = 512f,
        viewportHeight = 512f
    ).apply {
        // Primer path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(298.8f, 1.2f)
            curveToRelative(-3f, 2.3f, -4f, 6.5f, -2.3f, 9.8f)
            curveToRelative(1.6f, 3.2f, 2.3f, 3.4f, 12.6f, 5f)
            curveToRelative(26.6f, 4f, 52.2f, 18.7f, 60.2f, 34.6f)
            curveToRelative(7.4f, 14.6f, 1.1f, 42.3f, -17f, 74.9f)
            curveToRelative(-16f, 28.6f, -43.8f, 66.8f, -55.8f, 76.4f)
            curveToRelative(-14.5f, 11.6f, -25.2f, 16.4f, -43f, 19.5f)
            curveToRelative(-15.1f, 2.6f, -23.4f, 5.4f, -37.3f, 12.2f)
            curveToRelative(-10.3f, 5.1f, -13.6f, 7.2f, -14.8f, 9.5f)
            curveToRelative(-1.7f, 3.4f, -1.2f, 6.1f, 1.9f, 8.9f)
            curveToRelative(3f, 2.9f, 5f, 2.5f, 15.1f, -2.9f)
            curveToRelative(12.3f, -6.6f, 20.8f, -9.5f, 38.9f, -13.1f)
            curveToRelative(8.3f, -1.7f, 17.8f, -4.2f, 21.1f, -5.5f)
            curveToRelative(9.2f, -3.7f, 20.1f, -10.9f, 33.1f, -21.6f)
            curveToRelative(42.8f, -35.6f, 90.8f, -61.9f, 113.5f, -62.3f)
            curveToRelative(13.5f, -0.2f, 18.5f, 5.3f, 18.5f, 19.9f)
            curveToRelative(-0.1f, 11f, -2.2f, 17.1f, -10.6f, 30.5f)
            curveToRelative(-9.8f, 15.6f, -19.9f, 36.7f, -24.7f, 51.3f)
            curveToRelative(-4.2f, 12.9f, -9.2f, 33.6f, -9.2f, 38.2f)
            curveToRelative(0f, 1.7f, -0.5f, 2.5f, -1.2f, 2.3f)
            curveToRelative(-1.8f, -0.6f, -4.5f, -8.4f, -5.7f, -16f)
            curveToRelative(-1.4f, -8.5f, -5.5f, -11.8f, -11.1f, -8.8f)
            curveToRelative(-3.7f, 2f, -43.6f, 54.4f, -44.7f, 58.8f)
            curveToRelative(-1.3f, 5.1f, 4f, 10.1f, 9.4f, 8.7f)
            curveToRelative(1.2f, -0.3f, 3.3f, -2f, 4.6f, -3.8f)
            curveToRelative(11.5f, -15.8f, 29f, -38.7f, 29.5f, -38.7f)
            curveToRelative(0.4f, -0f, 2.1f, 2.6f, 3.7f, 5.8f)
            curveToRelative(5.1f, 9.7f, 14.3f, 12.6f, 23f, 7.2f)
            curveToRelative(4.5f, -2.8f, 5.4f, -4.9f, 8.6f, -20.9f)
            curveToRelative(1.7f, -8f, 4.9f, -20.5f, 7.3f, -27.6f)
            curveToRelative(6.4f, -19.3f, 11.2f, -28.9f, 26.5f, -53.7f)
            curveToRelative(12.8f, -20.9f, 13.1f, -46.5f, 0.7f, -59.6f)
            curveToRelative(-14.8f, -15.8f, -48f, -9.6f, -91.6f, 17.2f)
            curveToRelative(-5.8f, 3.5f, -10.6f, 6.3f, -10.8f, 6.1f)
            curveToRelative(-0.2f, -0.1f, 3.3f, -6.1f, 7.8f, -13.1f)
            curveToRelative(15.1f, -24f, 27.3f, -51.3f, 31f, -69.4f)
            curveToRelative(1.8f, -9f, 1.4f, -23.6f, -1f, -31.2f)
            curveToRelative(-6.2f, -20.1f, -31f, -38.5f, -62.2f, -46.2f)
            curveToRelative(-13.6f, -3.3f, -21.8f, -4.2f, -24f, -2.4f)
            close()
        }

        // Segundo path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(255.5f, 3.4f)
            curveToRelative(-22.8f, 6f, -39.9f, 15.9f, -55.3f, 32.1f)
            curveToRelative(-17.1f, 18.1f, -38.9f, 58.2f, -74.7f, 138f)
            curveToRelative(-27.2f, 60.5f, -36.8f, 78.3f, -53.6f, 99f)
            curveToRelative(-19.8f, 24.4f, -23.8f, 44.7f, -12.6f, 63.4f)
            curveToRelative(6.7f, 11.1f, 22f, 21.8f, 35.4f, 24.6f)
            curveToRelative(13.2f, 2.8f, 38.9f, 1.8f, 64.8f, -2.5f)
            curveToRelative(10.2f, -1.7f, 12.3f, -2.4f, 14.3f, -4.6f)
            curveToRelative(2.5f, -2.8f, 2.7f, -4.2f, 1.1f, -7.7f)
            curveToRelative(-2f, -4.4f, -4.7f, -4.8f, -16.7f, -2.7f)
            curveToRelative(-27.5f, 4.8f, -55.5f, 5.3f, -66.2f, 1.1f)
            curveToRelative(-7.7f, -2.9f, -16.6f, -10.4f, -20.4f, -17.1f)
            curveToRelative(-2.7f, -4.8f, -3.1f, -6.4f, -3.1f, -13.1f)
            curveToRelative(0f, -6.7f, 0.5f, -8.5f, 3.7f, -15f)
            curveToRelative(2.1f, -4.1f, 7.2f, -11.7f, 11.4f, -16.9f)
            curveToRelative(18.6f, -23.2f, 26.8f, -38.5f, 58.6f, -109f)
            curveToRelative(25.8f, -57.2f, 43.4f, -91.6f, 59.4f, -115.7f)
            curveToRelative(12.8f, -19.3f, 34.1f, -33.5f, 59.4f, -39.6f)
            curveToRelative(9.6f, -2.3f, 13f, -4.6f, 13f, -8.9f)
            curveToRelative(0f, -3.5f, -4f, -7.8f, -7.2f, -7.8f)
            curveToRelative(-1.3f, 0.1f, -6.3f, 1.2f, -11.3f, 2.4f)
            close()
        }

        // Tercer path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(250.3f, 62f)
            curveToRelative(-7.2f, 2.9f, -4.7f, 14f, 3.1f, 14f)
            curveToRelative(7.9f, -0f, 10.5f, -9.9f, 3.5f, -13.5f)
            curveToRelative(-3.2f, -1.7f, -3.5f, -1.7f, -6.6f, -0.5f)
            close()
        }

        // Cuarto path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(283.2f, 79.3f)
            curveToRelative(-4.6f, 4.9f, -1.4f, 12.1f, 5.3f, 12.1f)
            curveToRelative(2.7f, -0f, 4.3f, -0.6f, 5.6f, -2.3f)
            curveToRelative(5.9f, -7.3f, -4.5f, -16.6f, -10.9f, -9.8f)
            close()
        }

        // Quinto path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(257.4f, 91.3f)
            curveToRelative(-5.3f, 4.6f, -2.3f, 12.7f, 4.6f, 12.7f)
            curveToRelative(6.9f, -0f, 9.9f, -8.1f, 4.6f, -12.7f)
            curveToRelative(-1.5f, -1.2f, -3.6f, -2.3f, -4.6f, -2.3f)
            curveToRelative(-1f, -0f, -3.1f, 1.1f, -4.6f, 2.3f)
            close()
        }

        // Sexto path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(237.2f, 192.3f)
            curveToRelative(-1.2f, 1.3f, -2.2f, 3.6f, -2.2f, 5.1f)
            curveToRelative(0f, 3.4f, 4.1f, 7.6f, 7.5f, 7.6f)
            curveToRelative(3.3f, -0f, 7.5f, -4.2f, 7.5f, -7.5f)
            curveToRelative(0f, -3.5f, -4.2f, -7.5f, -7.8f, -7.5f)
            curveToRelative(-1.7f, -0f, -3.7f, 0.9f, -5f, 2.3f)
            close()
        }

        // Séptimo path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(309.9f, 243.2f)
            curveToRelative(-7.1f, 7.5f, -15.7f, 19f, -22.4f, 29.9f)
            curveToRelative(-5.7f, 9.1f, -16f, 29.7f, -18.5f, 37f)
            lineToRelative(-1.3f, 3.6f)
            lineToRelative(-19.1f, 6.2f)
            curveToRelative(-10.5f, 3.3f, -24.9f, 7.7f, -32.1f, 9.7f)
            curveToRelative(-16.9f, 4.6f, -18f, 5.1f, -19.4f, 8f)
            curveToRelative(-1.6f, 3.5f, -1.4f, 4.8f, 1f, 7.8f)
            curveToRelative(1.4f, 1.8f, 3f, 2.6f, 5.2f, 2.6f)
            curveToRelative(3.2f, -0f, 29.2f, -7f, 47.7f, -12.9f)
            curveToRelative(5.2f, -1.7f, 9.6f, -2.8f, 9.8f, -2.7f)
            curveToRelative(0.2f, 0.2f, -1.3f, 5.5f, -3.2f, 11.7f)
            curveToRelative(-13.9f, 44.8f, -20.2f, 82.7f, -19.3f, 115.9f)
            curveToRelative(0.5f, 20.5f, 3f, 33.3f, 8.3f, 43f)
            curveToRelative(5.6f, 10.3f, 18.2f, 11.9f, 25.5f, 3.3f)
            curveToRelative(1.8f, -2.1f, 4f, -8.3f, 7.4f, -19.9f)
            curveToRelative(11.5f, -40.7f, 25.2f, -77f, 41.1f, -109.1f)
            curveToRelative(11.3f, -22.8f, 11.9f, -25.1f, 7.2f, -28.6f)
            curveToRelative(-3.1f, -2.3f, -6.7f, -1.8f, -9.6f, 1.3f)
            curveToRelative(-2.8f, 3.1f, -18.2f, 34.4f, -25.5f, 52f)
            curveToRelative(-8.7f, 20.9f, -18.3f, 48.4f, -25.2f, 72f)
            curveToRelative(-7.3f, 25.1f, -7f, 24.3f, -8.5f, 20.5f)
            curveToRelative(-3.9f, -9.8f, -5.2f, -18.3f, -5.7f, -36f)
            curveToRelative(-0.5f, -18.3f, 0.5f, -30.9f, 4.3f, -51.8f)
            lineToRelative(1.6f, -8.8f)
            lineToRelative(2.9f, 2.7f)
            curveToRelative(3.8f, 3.6f, 9.3f, 3.9f, 12f, 0.5f)
            curveToRelative(3.4f, -4.2f, 2.5f, -7f, -4.6f, -14.1f)
            lineToRelative(-6.5f, -6.5f)
            lineToRelative(2.5f, -9.5f)
            curveToRelative(1.4f, -5.2f, 3f, -11f, 3.6f, -12.8f)
            lineToRelative(1.1f, -3.4f)
            lineToRelative(3.9f, 3.8f)
            curveToRelative(4.5f, 4.4f, 8.8f, 5f, 12.1f, 1.6f)
            curveToRelative(4f, -3.9f, 2.9f, -7.5f, -4.5f, -15f)
            lineToRelative(-6.7f, -6.8f)
            lineToRelative(3.4f, -10.1f)
            curveToRelative(4.8f, -14.3f, 4.5f, -14f, 8.6f, -9.8f)
            curveToRelative(4f, 4.1f, 8.8f, 4.7f, 12f, 1.5f)
            curveToRelative(3.6f, -3.6f, 2.6f, -7.5f, -3.6f, -14f)
            lineToRelative(-5.5f, -5.8f)
            lineToRelative(2.6f, -5.4f)
            curveToRelative(2.3f, -4.4f, 9.1f, -16.3f, 10.2f, -17.7f)
            curveToRelative(0.1f, -0.2f, 2.5f, 1.7f, 5.2f, 4.2f)
            curveToRelative(6.1f, 5.7f, 9.3f, 6.7f, 12.9f, 4f)
            curveToRelative(1.9f, -1.4f, 2.8f, -3.1f, 3f, -5.7f)
            curveToRelative(0.3f, -3.3f, -0.3f, -4.3f, -5.7f, -9.9f)
            lineToRelative(-6f, -6.3f)
            lineToRelative(6.4f, -7.2f)
            curveToRelative(3.6f, -4f, 6.8f, -8.4f, 7.1f, -9.8f)
            curveToRelative(1f, -3.9f, -2.4f, -7.8f, -7f, -8.2f)
            curveToRelative(-3.4f, -0.3f, -4.2f, 0.2f, -8.7f, 5f)
            close()
        }

        // Octavo path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(130.3f, 297f)
            curveToRelative(-7.2f, 3f, -4.5f, 14f, 3.4f, 14f)
            curveToRelative(3.6f, -0f, 7.3f, -3.8f, 7.3f, -7.5f)
            curveToRelative(0f, -4.9f, -5.9f, -8.5f, -10.7f, -6.5f)
            close()
        }

        // Noveno path del XML
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 0.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(156.7f, 306.7f)
            curveToRelative(-0.8f, 1f, -1.9f, 3f, -2.2f, 4.5f)
            curveToRelative(-0.6f, 2.2f, -0.1f, 3.3f, 2.3f, 5.8f)
            curveToRelative(3.6f, 3.5f, 6f, 3.8f, 9.6f, 0.9f)
            curveToRelative(3.3f, -2.6f, 3.6f, -7.9f, 0.6f, -10.9f)
            curveToRelative(-2.5f, -2.5f, -8.1f, -2.6f, -10.3f, -0.3f)
            close()
        }
    }.build()


  val HotDogIcon: ImageVector
      get() = ImageVector.Builder(
          name = "SausageIcon",
          defaultWidth = 512.dp,
          defaultHeight = 512.dp,
          viewportWidth = 512f,
          viewportHeight = 512f
      ).apply {
          // Path del XML
          path(
              fill = SolidColor(Color.Black),
              fillAlpha = 1.0f,
              strokeAlpha = 1.0f,
              strokeLineWidth = 0.0f,
              pathFillType = PathFillType.NonZero
          ) {
              moveTo(86.7f, 60.5f)
              curveToRelative(-16.9f, 3.4f, -34.4f, 17f, -41.9f, 32.5f)
              curveToRelative(-9.9f, 20.3f, -8.7f, 41.2f, 3.3f, 61f)
              curveToRelative(21.9f, 36.3f, 56.7f, 75f, 93.4f, 104.1f)
              curveToRelative(31.4f, 24.8f, 71.4f, 47.2f, 113.5f, 63.5f)
              lineToRelative(8.5f, 3.3f)
              lineToRelative(-14.6f, 0.1f)
              curveToRelative(-45.1f, 0.1f, -90.4f, -10.9f, -134.3f, -32.5f)
              curveToRelative(-16f, -7.9f, -20.7f, -9.4f, -31.6f, -10.1f)
              curveToRelative(-26.7f, -1.8f, -51.3f, 14f, -61.3f, 39.4f)
              curveToRelative(-3.9f, 9.9f, -4.9f, 25.9f, -2.3f, 36.2f)
              curveToRelative(3.9f, 15.4f, 13.2f, 28.5f, 26.6f, 37.3f)
              curveToRelative(10.6f, 6.9f, 44.9f, 23.5f, 62f, 30f)
              curveToRelative(33f, 12.6f, 65.7f, 20.4f, 104.5f, 24.9f)
              curveToRelative(17.3f, 2f, 73.4f, 1.7f, 91.5f, -0.5f)
              curveToRelative(52.1f, -6.5f, 94.2f, -19.1f, 139.2f, -41.9f)
              curveToRelative(28.2f, -14.3f, 36.5f, -21.3f, 44.3f, -37.3f)
              curveToRelative(6.2f, -13f, 7.7f, -27.1f, 4.3f, -41.5f)
              curveToRelative(-1.7f, -7.4f, -8.5f, -20.1f, -13.9f, -26.3f)
              lineToRelative(-5.2f, -5.8f)
              lineToRelative(0.2f, -9.3f)
              curveToRelative(0.1f, -5.5f, -0.4f, -12f, -1.3f, -15.9f)
              curveToRelative(-4.8f, -20.4f, -21.7f, -38.4f, -42.1f, -44.7f)
              curveToRelative(-5.6f, -1.7f, -11.2f, -2.3f, -27.5f, -3f)
              curveToRelative(-20.6f, -0.9f, -29.3f, -1.8f, -45f, -4.6f)
              curveToRelative(-77.4f, -13.9f, -150.6f, -58.7f, -196.8f, -120.4f)
              curveToRelative(-4.7f, -6.3f, -10.4f, -13.9f, -12.5f, -16.8f)
              curveToRelative(-2.2f, -2.9f, -6.7f, -7.3f, -10.1f, -9.9f)
              curveToRelative(-15.3f, -11.5f, -32.3f, -15.5f, -50.9f, -11.8f)
              close()
              moveTo(109.1f, 74.4f)
              curveToRelative(7.7f, 1.7f, 15.6f, 5.4f, 21.4f, 10.1f)
              curveToRelative(2.2f, 1.8f, 7.7f, 8.4f, 12.2f, 14.6f)
              curveToRelative(4.5f, 6.3f, 10.2f, 13.9f, 12.7f, 17f)
              lineToRelative(4.5f, 5.6f)
              lineToRelative(-13.2f, 10.4f)
              curveToRelative(-16.6f, 13.1f, -17.7f, 14.1f, -17.7f, 17.8f)
              curveToRelative(0f, 3.8f, 4.3f, 7.5f, 7.8f, 6.6f)
              curveToRelative(1.3f, -0.3f, 9.1f, -5.9f, 17.4f, -12.5f)
              lineToRelative(15.1f, -11.9f)
              lineToRelative(7.7f, 7.8f)
              curveToRelative(4.3f, 4.2f, 10.9f, 10.6f, 14.9f, 14f)
              curveToRelative(3.9f, 3.5f, 7.1f, 6.8f, 7.1f, 7.3f)
              curveToRelative(0f, 0.5f, -5.6f, 7.8f, -12.5f, 16.4f)
              curveToRelative(-9.7f, 12f, -12.5f, 16.1f, -12.5f, 18.4f)
              curveToRelative(0f, 5.9f, 6.4f, 9f, 10.8f, 5.2f)
              curveToRelative(1.2f, -0.9f, 7.3f, -8.2f, 13.7f, -16.2f)
              curveToRelative(6.4f, -8f, 12f, -14.6f, 12.3f, -14.7f)
              curveToRelative(0.4f, -0.2f, 4.7f, 2.6f, 9.6f, 6.1f)
              curveToRelative(4.9f, 3.5f, 14f, 9.4f, 20.2f, 13.2f)
              lineToRelative(11.3f, 6.7f)
              lineToRelative(-8.1f, 15.6f)
              curveToRelative(-4.5f, 8.6f, -8.7f, 16.5f, -9.5f, 17.6f)
              curveToRelative(-1.7f, 2.6f, -1.7f, 6.6f, 0.3f, 9.3f)
              curveToRelative(1.8f, 2.6f, 7.4f, 3f, 9.8f, 0.7f)
              curveToRelative(0.9f, -0.9f, 5.6f, -9.4f, 10.7f, -19f)
              curveToRelative(5f, -9.6f, 9.2f, -17.5f, 9.3f, -17.5f)
              curveToRelative(0.1f, -0f, 5.5f, 2.4f, 12f, 5.4f)
              curveToRelative(6.5f, 3f, 16.5f, 7.2f, 22.2f, 9.3f)
              curveToRelative(5.7f, 2.1f, 10.4f, 4.3f, 10.4f, 5f)
              curveToRelative(0f, 0.6f, -2.5f, 9.3f, -5.5f, 19.2f)
              curveToRelative(-3f, 10f, -5.5f, 19f, -5.5f, 20f)
              curveToRelative(0f, 1f, 0.8f, 2.9f, 1.8f, 4.2f)
              curveToRelative(2.2f, 2.6f, 7.5f, 3f, 9.8f, 0.7f)
              curveToRelative(0.8f, -0.8f, 4.1f, -10.2f, 7.3f, -20.9f)
              curveToRelative(4f, -13.1f, 6.3f, -19.4f, 7.2f, -19.3f)
              curveToRelative(0.8f, 0.1f, 7.3f, 1.5f, 14.4f, 3.2f)
              curveToRelative(7.2f, 1.7f, 15.3f, 3.4f, 18.1f, 3.8f)
              curveToRelative(2.8f, 0.3f, 5.7f, 1f, 6.3f, 1.4f)
              curveToRelative(1f, 0.5f, 1f, 3.9f, 0.2f, 14.6f)
              curveToRelative(-1.7f, 22f, -1.7f, 25.1f, 0.4f, 27.4f)
              curveToRelative(2.4f, 2.6f, 7.6f, 2.6f, 10f, -0f)
              curveToRelative(1.4f, -1.6f, 2f, -5.4f, 3.1f, -20.6f)
              curveToRelative(0.7f, -10.3f, 1.5f, -18.8f, 1.6f, -19f)
              curveToRelative(0.8f, -0.8f, 42.8f, 1.6f, 46.3f, 2.6f)
              curveToRelative(15.3f, 4.5f, 27.9f, 16.8f, 32.5f, 31.9f)
              curveToRelative(1.7f, 5.3f, 2.8f, 16.1f, 1.7f, 16.1f)
              curveToRelative(-0.2f, -0f, -2.9f, -0.9f, -6.1f, -1.9f)
              curveToRelative(-8.7f, -3.1f, -18.8f, -4.1f, -27.9f, -3f)
              curveToRelative(-9.2f, 1.1f, -16f, 3.6f, -31.2f, 11.2f)
              curveToRelative(-22.5f, 11.3f, -46.5f, 19.3f, -74.4f, 24.9f)
              lineToRelative(-15.3f, 3.1f)
              lineToRelative(-10.2f, -2.8f)
              curveToRelative(-40.1f, -11.1f, -84.7f, -31.7f, -120.5f, -55.7f)
              curveToRelative(-35.9f, -24.2f, -72.3f, -59.3f, -97.8f, -94.3f)
              curveToRelative(-9.3f, -12.9f, -18f, -26.9f, -20.1f, -32.6f)
              curveToRelative(-8.8f, -24f, 4f, -51.9f, 27.8f, -60.4f)
              curveToRelative(10f, -3.6f, 16.4f, -4.1f, 26.1f, -2.1f)
              close()
              moveTo(86.5f, 297f)
              curveToRelative(5.4f, 0.8f, 10.8f, 2.9f, 23.5f, 8.8f)
              curveToRelative(9.1f, 4.3f, 17.9f, 8.5f, 19.6f, 9.3f)
              lineToRelative(3.1f, 1.4f)
              lineToRelative(-7.3f, 16.5f)
              curveToRelative(-4.1f, 9.2f, -7.4f, 17.9f, -7.4f, 19.7f)
              curveToRelative(0f, 3.5f, 2.9f, 6.3f, 6.6f, 6.3f)
              curveToRelative(4.6f, -0f, 5.7f, -1.9f, 19.5f, -33.7f)
              lineToRelative(1.8f, -4.2f)
              lineToRelative(7.2f, 2.4f)
              curveToRelative(4f, 1.4f, 12.9f, 3.9f, 19.8f, 5.6f)
              curveToRelative(6.9f, 1.7f, 12.8f, 3.3f, 13f, 3.5f)
              curveToRelative(0.2f, 0.2f, -1.4f, 9.4f, -3.5f, 20.4f)
              curveToRelative(-3.5f, 18.5f, -3.7f, 20.4f, -2.3f, 22.8f)
              curveToRelative(1.1f, 2f, 2.4f, 2.8f, 5.1f, 3f)
              curveToRelative(5.7f, 0.5f, 6.8f, -1.8f, 11.2f, -24.2f)
              lineToRelative(3.9f, -19.8f)
              lineToRelative(4.1f, 0.7f)
              curveToRelative(10f, 1.5f, 20f, 2.6f, 31.9f, 3.2f)
              lineToRelative(12.7f, 0.6f)
              lineToRelative(0f, 20.9f)
              curveToRelative(0f, 20.8f, 0f, 20.9f, 2.5f, 23.3f)
              curveToRelative(1.3f, 1.4f, 3.4f, 2.5f, 4.5f, 2.5f)
              curveToRelative(1.1f, -0f, 3.2f, -1.1f, 4.5f, -2.5f)
              curveToRelative(2.5f, -2.4f, 2.5f, -2.5f, 2.5f, -23.3f)
              lineToRelative(0f, -20.9f)
              lineToRelative(13f, -0.6f)
              curveToRelative(7.1f, -0.4f, 18f, -1.4f, 24.1f, -2.3f)
              curveToRelative(6.1f, -0.8f, 11.3f, -1.4f, 11.5f, -1.2f)
              curveToRelative(0.1f, 0.2f, 2f, 9.2f, 4.2f, 20.1f)
              curveToRelative(4.2f, 21.3f, 5.3f, 23.7f, 10.5f, 23.7f)
              curveToRelative(3.9f, -0f, 6.7f, -2.6f, 6.7f, -6f)
              curveToRelative(0f, -1.5f, -1.6f, -10.8f, -3.5f, -20.6f)
              curveToRelative(-1.9f, -9.9f, -3.5f, -18.4f, -3.5f, -19f)
              curveToRelative(0f, -0.6f, 4.4f, -2.2f, 9.8f, -3.4f)
              curveToRelative(5.3f, -1.2f, 14.3f, -3.7f, 20f, -5.5f)
              lineToRelative(10.4f, -3.3f)
              lineToRelative(1.8f, 4.1f)
              curveToRelative(8.6f, 20f, 13.5f, 30.5f, 14.8f, 31.9f)
              curveToRelative(2.1f, 2.4f, 7.4f, 2.3f, 9.7f, -0.2f)
              curveToRelative(1f, -1.1f, 1.8f, -3.2f, 1.7f, -4.7f)
              curveToRelative(-0.1f, -1.6f, -3.4f, -10.2f, -7.5f, -19.3f)
              lineToRelative(-7.5f, -16.5f)
              lineToRelative(3.2f, -1.4f)
              curveToRelative(1.7f, -0.8f, 10.5f, -5f, 19.6f, -9.2f)
              curveToRelative(18.8f, -8.9f, 25.8f, -10.6f, 36.2f, -8.9f)
              curveToRelative(13.3f, 2.1f, 23f, 7.6f, 31.1f, 17.5f)
              curveToRelative(5.2f, 6.6f, 8.4f, 13.8f, 9.9f, 23.3f)
              curveToRelative(2f, 11.7f, -1.9f, 25.7f, -9.9f, 35.7f)
              curveToRelative(-5.8f, 7.1f, -12.9f, 12f, -31.1f, 21.3f)
              curveToRelative(-41.3f, 21.1f, -82.6f, 33.8f, -131.2f, 40.4f)
              curveToRelative(-22.5f, 3f, -76.6f, 3.3f, -98.5f, 0.5f)
              curveToRelative(-46.4f, -6f, -84.4f, -17f, -124.7f, -36f)
              curveToRelative(-19.7f, -9.3f, -31.8f, -16.6f, -38f, -22.8f)
              curveToRelative(-27f, -27.5f, -11f, -74.3f, 27.3f, -79.9f)
              curveToRelative(3f, -0.4f, 5.6f, -0.8f, 5.9f, -0.9f)
              curveToRelative(0.3f, -0f, 3.7f, 0.4f, 7.5f, 0.9f)
              close()
          }
      }.build()
