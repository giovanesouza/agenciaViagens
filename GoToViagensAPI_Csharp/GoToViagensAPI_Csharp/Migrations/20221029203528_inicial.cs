using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace GoToViagensAPI_Csharp.Migrations
{
    public partial class inicial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Destinos",
                columns: table => new
                {
                    DestinoId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Embarque = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Destino = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    DataIda = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DataVolta = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Preco = table.Column<float>(type: "real", nullable: false),
                    QuantidadeDisponivel = table.Column<int>(type: "int", nullable: false),
                    Condicao = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Categoria = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Destinos", x => x.DestinoId);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Destinos");
        }
    }
}
