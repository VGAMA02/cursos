using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TareasMVC.Migrations
{
    /// <inheritdoc />
    public partial class AdminRol : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.Sql(@"IF NOT EXISTS(SELECT Id FROM AspNetRoles WHERE Id = '28fe9887-1f13-4a9c-b39d-cf934d565a02')
                                BEGIN
	                                INSERT INTO AspNetRoles (Id,[Name],[NormalizedName]) VALUES ('28fe9887-1f13-4a9c-b39d-cf934d565a02','admin','ADMIN');
                                END");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.Sql(@"DELETE AspNetRoles WHERE Id = '28fe9887-1f13-4a9c-b39d-cf934d565a02'");
        }
    }
}
