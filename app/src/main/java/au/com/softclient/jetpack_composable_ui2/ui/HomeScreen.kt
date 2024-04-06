package au.com.softclient.jetpack_composable_ui2.ui

//import android.graphics.Path
import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.changelist.Operation.MoveCurrentGroup.Offset
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import au.com.softclient.jetpack_composable_ui2.Feature
import au.com.softclient.jetpack_composable_ui2.R
import au.com.softclient.jetpack_composable_ui2.ui.theme.ButtonBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.DarkerButtonBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.DeepBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.LightRed
import au.com.softclient.jetpack_composable_ui2.ui.theme.TextWhite

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            GreetingSection();
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Type X1", "Type X2", "Type X3"));
            CurrentMeditation();

        }
    }
}

//Section-1
@Composable
fun GreetingSection(
    name: String = "Pure"
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ){
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(text="Good Morning, $name",
                style = MaterialTheme.typography.headlineSmall,
                );
            Text(
                text = "we wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium
            )
        };
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        );
    }
}

//Section 2 - Lazy Row
@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember{
        mutableStateOf( 0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }

        }

    }
}


//Section - 3
@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(text="Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
            );
            Text(
                text = "Meditation * 3 - 10 Min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        };
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            );

        }

    }

}

//Section - 4
@Composable
fun FeatureSection(features: List<Feature>){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp),
            )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight(),
            content = {
                items(features.size){

                }
            }
        )

    }

}

@Composable
fun FeatureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth;
        val height = constraints.maxHeight;

        //Medium Colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f);
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            quadraticBezierTo(
                mediumColoredPoint2.x,
                mediumColoredPoint2.y,
                (mediumColoredPoint1.x + mediumColoredPoint2.x)/2f,
                (mediumColoredPoint1.y + mediumColoredPoint2.y)/2f,
            )
        }

    }

}